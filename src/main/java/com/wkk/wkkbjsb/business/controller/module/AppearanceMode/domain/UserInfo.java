package com.wkk.wkkbjsb.business.controller.module.AppearanceMode.domain;

import lombok.Data;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller.module.AppearanceMode.domain
 * @Description : TODO
 * @Create on : 2021/1/26 14:35
 * @email : lgy961228@gamil.com
 **/

@Data
public class UserInfo {

    private String username;

    private int age;

    private String address;


    public UserInfo(String username, int age, String address) {

        this.username = username;
        this.age = age;
        this.address = address;
    }
}
