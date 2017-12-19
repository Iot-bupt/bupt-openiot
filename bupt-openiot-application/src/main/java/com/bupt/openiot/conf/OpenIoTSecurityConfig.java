package com.bupt.openiot.conf;

import com.bupt.openiot.exception.OpenIoTErrorResponseHandler;
import com.bupt.openiot.service.security.auth.jwt.*;
import com.bupt.openiot.service.security.auth.jwt.extractor.TokenExtractor;
import com.bupt.openiot.service.security.auth.rest.RestAuthenticationProvider;
import com.bupt.openiot.service.security.auth.rest.RestLoginProcessingFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dy on 2017/4/22.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class OpenIoTSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
    public static final String JWT_TOKEN_QUERY_PARAM = "token";

    public static final String WEBJARS_ENTRY_POINT = "/webjars/**";
    public static final String DEVICE_API_ENTRY_POINT = "/api/v1/**";
    public static final String FORM_BASED_LOGIN_ENTRY_POINT = "/api/auth/login";
    public static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/token";
    public static final String[] NON_TOKEN_BASED_AUTH_ENTRY_POINTS = new String[] {"/index", "/static/**", "/api/noauth/**", "/webjars/**"};
    public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
    public static final String WS_TOKEN_BASED_AUTH_ENTRY_POINT = "/api/ws/**";

    @Autowired
    private OpenIoTErrorResponseHandler restAccessDeniedHandler;
    @Autowired
    private AuthenticationSuccessHandler successHandler;  // 登录成功处理类
    @Autowired
    private AuthenticationFailureHandler failureHandler;  // 登录失败处理类
    @Autowired
    private RestAuthenticationProvider restAuthenticationProvider;  // 该类实现了用户登录认证的逻辑
    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;  // 该类实现了JWT校验
    @Autowired
    private RefreshTokenAuthenticationProvider refreshTokenAuthenticationProvider;  // 该类实现了刷新Token校验
    @Autowired
    private OpenIoTServerConfig openIoTServerConfig;  // 注入需要连接的OpenIoT平台地址

    @Autowired
    @Qualifier("jwtHeaderTokenExtractor")
    private TokenExtractor jwtHeaderTokenExtractor;

    @Autowired
    @Qualifier("jwtQueryTokenExtractor")
    private TokenExtractor jwtQueryTokenExtractor;

    @Autowired private AuthenticationManager authenticationManager;

    @Autowired private ObjectMapper objectMapper;


    /**
     * 登录前过滤器，获取从登陆页面传送的邮箱与密码，将邮箱与密码存入UsernamePasswordAuthenticationToken中
     * @return
     * @throws Exception
     */
   @Bean
    protected RestLoginProcessingFilter buildRestLoginProcessingFilter() throws Exception {
        RestLoginProcessingFilter filter = new RestLoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT, successHandler,
                failureHandler, objectMapper, openIoTServerConfig);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    /**
     * 普通访问url过滤器，从请求头head中获取访问带上的X-Authorization字段，将该字段的值放入Token中
     * @return
     * @throws Exception
     */
    @Bean
    protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter() throws Exception {
        @SuppressWarnings({ "rawtypes", "unchecked" })
		List<String> pathsToSkip = new ArrayList(Arrays.asList(NON_TOKEN_BASED_AUTH_ENTRY_POINTS));
        pathsToSkip.addAll(Arrays.asList(WS_TOKEN_BASED_AUTH_ENTRY_POINT, TOKEN_REFRESH_ENTRY_POINT, FORM_BASED_LOGIN_ENTRY_POINT, DEVICE_API_ENTRY_POINT, WEBJARS_ENTRY_POINT));
        SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, TOKEN_BASED_AUTH_ENTRY_POINT);
        JwtTokenAuthenticationProcessingFilter filter
                = new JwtTokenAuthenticationProcessingFilter(failureHandler, jwtHeaderTokenExtractor, matcher);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    /**
     * 访问刷新页面，获取request请求体中的refreshToken字段，存入Token
     * @return
     * @throws Exception
     */
    @Bean
    protected RefreshTokenProcessingFilter buildRefreshTokenProcessingFilter() throws Exception {
        RefreshTokenProcessingFilter filter = new RefreshTokenProcessingFilter(TOKEN_REFRESH_ENTRY_POINT, successHandler, failureHandler, objectMapper);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    /**
     * Web Socket访问时，获取request请求参数中的token参数值，将值存入Token中
     * @return
     * @throws Exception
     */
    @Bean
    protected JwtTokenAuthenticationProcessingFilter buildWsJwtTokenAuthenticationProcessingFilter() throws Exception {
        // 路径匹配
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(WS_TOKEN_BASED_AUTH_ENTRY_POINT);
        JwtTokenAuthenticationProcessingFilter filter
                = new JwtTokenAuthenticationProcessingFilter(failureHandler, jwtQueryTokenExtractor, matcher);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置自定义处理器
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(restAuthenticationProvider);  //配置用户登录自定义处理器
        auth.authenticationProvider(jwtAuthenticationProvider);  //配置普通访问自定义处理器
        auth.authenticationProvider(refreshTokenAuthenticationProvider);  //配置刷新访问自定义处理
    }

    /**
     * 创建密码加密编码器
     * @return
     */
    @Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Request层面的配置，对应XML Configuration中的<http>元素
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl().disable().frameOptions().disable()
                .and()
                .csrf().disable()   // 禁用security的csrf
                .exceptionHandling()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(WEBJARS_ENTRY_POINT).permitAll() // Webjars 不拦截
                .antMatchers(DEVICE_API_ENTRY_POINT).permitAll() // Device HTTP 传输 API
                .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll() // 登录请求接口
                .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll() // Token 刷新接口
                .antMatchers(NON_TOKEN_BASED_AUTH_ENTRY_POINTS).permitAll() // 静态资源、用户激活、密码重置
                .and()
                .authorizeRequests()
                .antMatchers(WS_TOKEN_BASED_AUTH_ENTRY_POINT).authenticated() // WebSocket API 需要授权
                .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated() // 其他所有的API均需要授权
                .and()
                .exceptionHandling().accessDeniedHandler(restAccessDeniedHandler)
                .and()
                .addFilterBefore(buildRestLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildRefreshTokenProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildWsJwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
