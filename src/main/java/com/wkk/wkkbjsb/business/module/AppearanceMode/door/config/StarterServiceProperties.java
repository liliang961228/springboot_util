package com.wkk.wkkbjsb.business.module.AppearanceMode.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller.module.AppearanceMode.door.config
 * @Description : TODO
 * @Create on : 2021/1/26 15:53
 * @email : lgy961228@gamil.com
 **/

@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

}
