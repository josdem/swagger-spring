package com.jos.dem.swagger.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams

import com.jos.dem.swagger.service.UserService
import com.jos.dem.swagger.model.User

@Api(description="knows how receive manage user requests")
@RestController
@RequestMapping("/user/*")
class UserController {

  @Autowired
  UserService userService

  @ApiImplicitParams([
  @ApiImplicitParam(name = "uuid", value = "User's uuid", required = true, dataType = "string", paramType = "query")
  ])
  @RequestMapping("/{uuid}")
  User index(@PathVariable String uuid){
    userService.getByUuid(uuid)
  }

}
