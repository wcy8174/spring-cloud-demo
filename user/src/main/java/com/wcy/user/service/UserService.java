package com.wcy.user.service;

import com.wcy.user.module.User;
import com.wcy.user.utils.ApiResponseData;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    ApiResponseData register(User user);

    ApiResponseData login(User user);
}
