package com.wcy.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.wcy.user.service.UserService;
import com.wcy.user.utils.ApiResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wcy.user.module.User;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody @Valid String  userString) {

        Gson gson = new Gson();
        User user = gson.fromJson(userString, User.class);
        ApiResponseData register = userService.register(user);
        return gson.toJson(register);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid String userString){

        Gson gson = new Gson();
        ApiResponseData login = userService.login(gson.fromJson(userString,User.class));

        return gson.toJson(login);
    }

}
