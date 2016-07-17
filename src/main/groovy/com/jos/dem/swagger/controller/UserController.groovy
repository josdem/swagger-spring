package com.jos.dem.swagger.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class UserController {

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  String index(){
    "index"
  }

}
