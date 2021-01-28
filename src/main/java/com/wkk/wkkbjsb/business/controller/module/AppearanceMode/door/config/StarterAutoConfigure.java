package com.wkk.wkkbjsb.business.controller.module.AppearanceMode.door.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller.module.AppearanceMode.door.config
 * @Description : TODO
 * @Create on : 2021/1/26 15:52
 * @email : lgy961228@gamil.com
 **/

@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "itstack.door", value = "enabled",
            havingValue = "true")
    StarterService starterService() {
        return new StarterService(properties.getUserStr());
    }
}
