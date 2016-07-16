package com.jos.dem.swagger.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView

@Configuration
@EnableWebMvc
class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/libs/")
  }

  @Override
  void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home")
  }

  @Bean
  ViewResolver viewResolver(){
    InternalResourceViewResolver resolver = new InternalResourceViewResolver()
    resolver.setViewClass(JstlView.class)
    resolver.setPrefix("/WEB-INF/jsp/")
    resolver.setSuffix(".jsp")
    resolver
  }

}
