package com.example.demo.dto;

import java.util.Date;

/**
 * @author yibozhang@ctrip.com
 * @create: 2021-04-09 14:48
 * @description
 **/
public class UserDTO {
    private String username;
    private String sex;
    private Date birthday;

    public UserDTO(){}

    public UserDTO(String username,String sex,Date birthday){
        this.username=username;
        this.sex=sex;
        this.birthday=birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
