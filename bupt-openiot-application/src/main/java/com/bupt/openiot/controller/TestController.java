package com.bupt.openiot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bupt.openiot.common.data.User;
import com.bupt.openiot.dao.user.UserService;
import com.github.pagehelper.PageInfo;

/**
 * Created by dy on 2017/4/21.
 */
@RestController
@RequestMapping("/api")
public class TestController {

   @Autowired
    private UserService userService;

    @RequestMapping("/noauth/test")
    public PageInfo<User> test() {
        List<User> userInfoList = userService.getAll();
    	/*List<User> userInfoList = new ArrayList();*/
        return new PageInfo<User>(userInfoList);
    	
    }

    @RequestMapping("/noauth/light/turnon")
    public String turnOn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return "token" + session.getAttribute("token") + "refreshToken" + session.getAttribute("refreshToken");
    }

    @RequestMapping(name = "HelloService", method = RequestMethod.GET, path = "/noauth/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/noauth/test/send")
    @ResponseBody
    public Map<String, String> sendPost(HttpServletRequest request) {
        Map<String, String> maps = new HashMap<String, String>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        maps.put("username", username);
        maps.put("password", password);
        return maps;
    }

    @RequestMapping(value = "/test/sendpost/file",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> sendPostFile(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
        Map<String, String> maps = new HashMap<String, String>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        maps.put("username", username);
        maps.put("password", password);

        try {
            for(MultipartFile file : files){
                String fileName = file.getOriginalFilename();
                fileName = new String(fileName.getBytes(),"UTF-8");
                InputStream is = file.getInputStream();
                if (fileName != null && !("".equals(fileName))) {
                    File directory = new File("D://test//httpclient//file");
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    String filePath = ("D://test//httpclient//file") + File.separator + fileName;
                    FileOutputStream fos = new FileOutputStream(filePath);
                    byte[] buffer = new byte[1024];
                    while (is.read(buffer) > 0) {
                        fos.write(buffer, 0, buffer.length);
                    }
                    fos.flush();
                    fos.close();
                    maps.put("file--"+fileName, "uploadSuccess");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maps;
    }
}
