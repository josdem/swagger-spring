package com.jos.dem.swagger.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import com.jos.dem.swagger.service.UserService;
import com.jos.dem.swagger.command.UserCommand;
import com.jos.dem.swagger.model.User;

@Api(description="knows how receive manage user requests")
@RestController
@RequestMapping("/users/*")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping
  public List<User> getAll(){
    return userService.getAll();
  }

  @ApiImplicitParam(name = "uuid", value = "User's uuid", required = true, dataType = "string", paramType = "query")
  @RequestMapping(method = GET, value="{uuid}")
  public User getByUuid(@PathVariable String uuid){
    return userService.getByUuid(uuid);
  }

  @RequestMapping(method = POST, consumes="application/json")
  public User create(@RequestBody UserCommand command){
    return userService.create(command);
  }

}

