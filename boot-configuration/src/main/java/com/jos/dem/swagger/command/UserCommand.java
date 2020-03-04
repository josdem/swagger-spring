package com.jos.dem.swagger.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "UserModel", description = "Model who represents an user entity")
public class UserCommand {
  @ApiModelProperty(value = "User's uuid", required = true)
  @NotBlank(message = "uuid is required")
  private String uuid;

  @ApiModelProperty(value = "User's name", required = true)
  @NotBlank(message = "name is required")
  private String name;

  @ApiModelProperty(value = "User's email", required = true)
  @NotBlank(message = "email is required")
  private String email;
}
