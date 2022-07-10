package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 用户实体表，isAdmin为真，是管理员，为假，是普通游客，电话号码唯一(User)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:46:05
 */
public class User implements Serializable {
    private static final long serialVersionUID = 581614191492515789L;
    
    private Long userId;
    
    private String name;
    
    private String phoneNumber;
    
    private String password;
    
    private Integer isAdmin;
    
    private String icon;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}

