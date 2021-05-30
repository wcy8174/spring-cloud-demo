package com.wcy.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.wcy.client.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserClient userClient;

    @PostMapping("/register")
    public String register(@RequestBody @Valid JSONObject userObject) {

        return userClient.register(userObject.toJSONString());
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid JSONObject userObject){

        return userClient.login(userObject.toJSONString());
    }
}
