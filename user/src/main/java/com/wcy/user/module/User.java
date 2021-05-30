package com.wcy.user.module;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class User {

    /**
     * 自增ID
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * 账户名
     *
     */
    @Column(nullable = false)
    private String account;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * 用户名
     */
    @Column
    private String user_name;

    /**
     * 邮箱
     */
    @Column
    private String email;

    /**
     * 手机号
     */
    @Column
    private String phone_num;

    /**
     * 公司
     */
    @Column
    private String company;

    public User(String account, String password, String user_name) {
        this.account = account;
        this.password = password;
        this.user_name = user_name;
    }

    public User(String account, String password) {
        this(account,password,account);
    }

    public User(int id, String account, String password, String user_name, String email, String phone_num, String company) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.user_name = user_name;
        this.email = email;
        this.phone_num = phone_num;
        this.company = company;
    }
}
