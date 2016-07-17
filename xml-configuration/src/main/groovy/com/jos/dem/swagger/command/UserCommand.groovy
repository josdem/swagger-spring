package com.jos.dem.swagger.command

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value="UserCommand", description="Generic command from users")
class UserCommand {
  @ApiModelProperty(value = "User's uuid", allowableValues = "aphanumeric")
  String uuid
  @ApiModelProperty(value = "User's name", allowableValues = "text")
  String name
  @ApiModelProperty(value = "User's email", allowableValues = "email@domain")
  String email
}

