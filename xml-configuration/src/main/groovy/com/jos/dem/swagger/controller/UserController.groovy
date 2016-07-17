package com.jos.dem.swagger.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
class UserController {

  @RequestMapping("/")
  String index(){
    'Hello World!'
  }

}

