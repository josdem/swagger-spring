package com.jos.dem.swagger.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="UserModel", description="Model who represents an user entity")
public class UserCommand {
  @ApiModelProperty(value = "User's uuid", allowableValues = "aphanumeric")
  private String uuid;
  @ApiModelProperty(value = "User's name", allowableValues = "text")
  private String name;
  @ApiModelProperty(value = "User's email", allowableValues = "email@domain")
  private String email;
}


