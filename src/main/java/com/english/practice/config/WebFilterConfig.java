package com.english.practice.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @version  [版本号, 2019年5月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Configuration
public class WebFilterConfig {
    @Bean
    public FilterRegistrationBean someFilterRegistration1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new PracticeFilter());
        return registration;
    }
}
