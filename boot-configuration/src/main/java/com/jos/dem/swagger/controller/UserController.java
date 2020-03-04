package com.jos.dem.swagger.controller;

import com.jos.dem.swagger.command.UserCommand;
import com.jos.dem.swagger.model.User;
import com.jos.dem.swagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="knows how receive manage user requests")
@RestController
@RequestMapping("/users/*")
@RequiredArgsConstructor
public class UserController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  private final UserService userService;

  @GetMapping
  public List<User> getAll(){
    log.info("Getting all users");
    return userService.getAll();
  }

  @ApiImplicitParam(name = "uuid", value = "User's uuid", required = true, dataType = "string", paramType = "path")
  @GetMapping(value = "{uuid}")
  public User getByUuid(@PathVariable String uuid){
    log.info("Getting user by uuid: " + uuid);
    return userService.getByUuid(uuid);
  }

  @PostMapping(consumes="application/json")
  public User create(@RequestBody UserCommand command){
    log.info("Saving user: w/uuid: " + command.getUuid());
    return userService.create(command);
  }

}

