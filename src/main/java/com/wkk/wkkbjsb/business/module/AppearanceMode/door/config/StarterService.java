package com.wkk.wkkbjsb.business.module.AppearanceMode.door.config;

import org.springframework.util.StringUtils;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller.module.AppearanceMode.door.config
 * @Description : TODO
 * @Create on : 2021/1/26 15:53
 * @email : lgy961228@gamil.com
 **/
public class StarterService {

    private String userStr;
    public StarterService(String userStr) {
        this.userStr = userStr;
    }
    public String[] split(String separatorChar) {
        return StringUtils.split(this.userStr, separatorChar);
    }
}
