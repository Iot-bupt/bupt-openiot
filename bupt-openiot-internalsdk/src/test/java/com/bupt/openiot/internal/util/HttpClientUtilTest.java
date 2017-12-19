package com.bupt.openiot.internal.util;

import com.bupt.openiot.internalsdk.util.HttpClientUtil;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dy on 2017/6/4.
 */
public class HttpClientUtilTest {

    /**
     * 正常回显
     */
    @Test
    public void testSendHttpPost1() {
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://localhost:9090/api/noauth/test/send?" +
                        "username=test01&password=123456");
        System.out.println("response content:" + responseContent);
    }

    /**
     * 异常，response content:{"password":null,"username":null}
     */
    @Test
    public void testSendHttpPost2() {
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://10.108.219.194:8080/api/auth/login", "username=tenant@openiot.org&password=tenant");
        System.out.println("response content:" + responseContent);
    }

    /**
     * 正常回显
     */
    @Test
    public void testSendHttpPost3() {
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("username", "tenant@openiot.org");
        maps.put("password", "tenant");
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://10.108.219.194:8080/api/auth/login", maps);
        System.out.println("response content:" + responseContent);
    }

    @Test
    public void testSendHttpPost4() {
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("username", "test01");
        maps.put("password", "123456");
        List<File> fileLists = new ArrayList<File>();
        fileLists.add(new File("D://test//httpclient//1.png"));
        fileLists.add(new File("D://test//httpclient//1.txt"));
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://localhost:9090/api/noauth/test/sendpost/file", maps, fileLists);
        System.out.println("response content:" + responseContent);
    }

    @Test
    public void testSendHttpGet() {
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpGet("http://localhost:9090/api/noauth/test/send?username=test01&password=123456");
        System.out.println("response content:" + responseContent);
    }

    @Test
    public void testSendHttpsGet() {
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpsGet("https://www.baidu.com");
        System.out.println("response content:" + responseContent);
    }
}
