package com.wkk.wkkbjsb.business.controller.module.AppearanceMode.web;

import com.wkk.wkkbjsb.business.controller.module.AppearanceMode.domain.UserInfo;
import com.wkk.wkkbjsb.business.controller.module.AppearanceMode.door.annotation.DoDoor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller.module.AppearanceMode.web
 * @Description : TODO
 * @Create on : 2021/1/26 14:36
 * @email : lgy961228@gamil.com
 **/

@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private int port;
    /**
     * key：需要从⼊参取值的属性字段，如果是对象则从对象中取值，如果是单个值则直接使⽤
     * returnJson：预设拦截时返回值，是返回对象的Json
     *
     * http://localhost:8080/api/queryUserInfo?userId=1001
     * http://localhost:8080/api/queryUserInfo?userId=⼩团团
     */
    @RequestMapping(path = "/api/queryUserInfo", method =
            RequestMethod.GET)
    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"⾮⽩名单 可访问⽤户拦截！\"}")
    public UserInfo queryUserInfo(@RequestParam String userId) {
        return new UserInfo("⾍⾍:" + userId, 19, "天津市南开区旮旯胡同100号");
    }
}
