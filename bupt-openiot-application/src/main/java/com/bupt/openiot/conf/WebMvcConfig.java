package com.bupt.openiot.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created by dy on 2017/4/21.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置页面静态资源,存放css、js文件
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
/*    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public DispatcherServlet dispatcherServlet(){
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        return dispatcherServlet;
    }

    @Bean
    public ServletContextTemplateResolver templateResolver() {
    	SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/static/");
        resolver.setSuffix(".html");
         resolver.setTemplateMode("HTML");
        resolver.setOrder(1);
        return resolver;
    }*/

}
