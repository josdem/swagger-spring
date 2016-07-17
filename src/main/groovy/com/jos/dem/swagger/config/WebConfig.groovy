package com.jos.dem.swagger.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.view.InternalResourceViewResolver

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
}
