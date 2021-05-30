package com.wcy.user.repository;


import com.wcy.user.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query(value = "select account from user where account like %?1%",
            nativeQuery = true)
    List<String> findUserName(String account);


    @Query(value = "select  id, account, password, user_name, email, phone_num, company from user where account = ?1",
            nativeQuery = true)
    List<User> findUser(String account);


    @Transactional
    @Modifying
    @Query(value = "insert into user (account, password) values (?1, ?2)",
            nativeQuery = true)
    int insertUser(String account, String password);


}
