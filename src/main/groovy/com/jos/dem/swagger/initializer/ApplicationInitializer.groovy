package com.jos.dem.swagger.initializer

import javax.servlet.ServletContext
import javax.servlet.ServletRegistration.Dynamic
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletException

import com.jos.dem.swagger.config.AppConfig
import com.jos.dem.swagger.config.ApplicationSwaggerConfig

class ApplicationInitializer implements WebApplicationInitializer {

  void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext()
    ctx.register(AppConfig.class)
    ctx.register(ApplicationSwaggerConfig.class)
    ctx.setServletContext(servletContext)
    Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx))
    dynamic.addMapping("/")
    dynamic.setLoadOnStartup(1)
  }

}
