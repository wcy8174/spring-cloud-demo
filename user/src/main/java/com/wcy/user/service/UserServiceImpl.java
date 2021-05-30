package com.wcy.user.service;

import com.wcy.user.module.User;
import com.wcy.user.repository.UserRepository;
import com.wcy.user.utils.ApiResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public ApiResponseData register(User user) {
        List<User> userList = userRepository.findUser(user.getAccount());
        if(userList != null && userList.size() >0){
            return new ApiResponseData(1,"用户已经存在","failure");
        }
        userRepository.insertUser(user.getAccount(), user.getPassword());
        return new ApiResponseData(0,"success","success");
    }


    @Override
    public ApiResponseData login(User user) {

        List<User> userList = userRepository.findUser(user.getAccount());
        if(userList == null || userList.size() < 1){
            return new ApiResponseData(0,"用户名错误","failure");
        }
        if(user.getPassword().equals(userList.get(0).getPassword())){
            return  new ApiResponseData(0,"","success");
        }else {
            return new ApiResponseData(1,"密码错误","failure");
        }
    }
}
