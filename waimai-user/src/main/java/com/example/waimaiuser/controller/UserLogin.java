package com.example.waimaiuser.controller;

import com.example.waimaiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;

@RestController
public class UserLogin {

    @Autowired
    private UserService userService;

    @GetMapping("/userlogin")
    public String login(String username, String password, HttpServletResponse response){
        System.out.println(username + password);
        Boolean login = userService.loginByUsername(username, password, response);
        if (login){
            return "4321";
        }
        return "12445";
    }

    @GetMapping("/logout")
    public String userLogout(){
        System.out.println(124);
        userService.logout();
        return "";
    }
}
