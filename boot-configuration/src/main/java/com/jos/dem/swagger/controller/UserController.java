package com.jos.dem.swagger.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import com.jos.dem.swagger.service.UserService;
import com.jos.dem.swagger.command.UserCommand;
import com.jos.dem.swagger.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Api(description="knows how receive manage user requests")
@RestController
@RequestMapping("/users/*")
public class UserController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserService userService;

  @RequestMapping(method = GET)
  public List<User> getAll(){
    log.info("Getting all users");
    return userService.getAll();
  }

  @ApiImplicitParam(name = "uuid", value = "User's uuid", required = true, dataType = "string", paramType = "query")
  @RequestMapping(method = GET, value = "{uuid}")
  public User getByUuid(@PathVariable String uuid){
    log.info("Getting user by uuid: " + uuid);
    return userService.getByUuid(uuid);
  }

  @RequestMapping(method = POST, consumes="application/json")
  public User create(@RequestBody UserCommand command){
    log.info("Saving user: w/uuid: " + command.getUuid());
    return userService.create(command);
  }

}

