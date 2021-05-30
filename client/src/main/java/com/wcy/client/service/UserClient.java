package com.wcy.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



@FeignClient(name = "user-service")
public interface UserClient {


    @PostMapping(value = "/user/register")
    String register(@RequestBody String data);


    @PostMapping(value = "/user/login")
    String login(@RequestBody String data);


//    @RequestMapping(value = "/method/check",method = RequestMethod.GET)
//    String checkMethod(@RequestParam("methodName") String methodName, @RequestParam("params") String params);
}
