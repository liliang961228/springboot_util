package com.wkk.wkkbjsb.business.module.AppearanceMode.door.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller.module.AppearanceMode.door.annotation
 * @Description : TODO
 * @Create on : 2021/1/26 15:52
 * @email : lgy961228@gamil.com
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoDoor {

    String key() default "";

    String returnJson() default "";
}
