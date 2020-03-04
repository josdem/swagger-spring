package com.jos.dem.swagger.controller;

import com.jos.dem.swagger.command.UserCommand;
import com.jos.dem.swagger.model.User;
import com.jos.dem.swagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "knows how receive manage user requests")
@RestController
@RequestMapping("/users/*")
@RequiredArgsConstructor
public class UserController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  private final UserService userService;

  @ApiOperation(value = "Getting all users")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Getting all users"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "Something went wrong")
      })
  @GetMapping
  public List<User> getAll() {
    log.info("Getting all users");
    return userService.getAll();
  }

  @ApiImplicitParams(
      value = {
        @ApiImplicitParam(
            name = "uuid",
            required = true,
            dataType = "string",
            paramType = "path",
            value = "User's uuid")
      })
  @GetMapping(value = "{uuid}")
  public User getByUuid(@PathVariable String uuid) {
    log.info("Getting user by uuid: " + uuid);
    return userService.getByUuid(uuid);
  }

  @PostMapping(consumes = "application/json")
  public User create(@RequestBody UserCommand command) {
    log.info("Saving user: w/uuid: " + command.getUuid());
    return userService.create(command);
  }

}
