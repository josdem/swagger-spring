package com.jos.dem.swagger.controller;

import com.jos.dem.swagger.command.UserDto;
import com.jos.dem.swagger.model.User;
import com.jos.dem.swagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "knows how receive manage user requests")
@Validated
@RestController
@RequestMapping("/users")
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

  @ApiOperation(value = "Get user by uuid")
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Getting all users"),
          @ApiResponse(code = 400, message = "Bad request"),
          @ApiResponse(code = 500, message = "Something went wrong")
      })
  @ApiImplicitParams(
      value = {
        @ApiImplicitParam(
            name = "uuid",
            required = true,
            dataType = "string",
            paramType = "path",
            value = "User's uuid")
      })
  @GetMapping(value = "/{uuid}")
  public User getByUuid(
      @PathVariable
          @Pattern(
              regexp =
                  "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
              message = "Invalid uuid format")
          String uuid) {
    log.info("Getting user by uuid: " + uuid);
    return userService.getByUuid(uuid);
  }

  @ApiOperation(value = "Create user")
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "User created"),
          @ApiResponse(code = 400, message = "Bad request"),
          @ApiResponse(code = 500, message = "Something went wrong")
      })
  @PostMapping(consumes = "application/json")
  public User create(@Valid @RequestBody UserDto userDto) {
    log.info("Saving user: w/uuid: " + userDto.getUuid());
    return userService.create(userDto);
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<String> handleException(ConstraintViolationException ce) {
    return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
