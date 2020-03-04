package com.jos.dem.swagger.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "UserModel", description = "Model who represents an user entity")
public class UserCommand {
  @ApiModelProperty(value = "User's uuid", required = true)
  @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$", message = "Invalid uuid format")
  private String uuid;

  @ApiModelProperty(value = "User's name", required = true)
  @NotBlank(message = "name is required")
  private String name;

  @ApiModelProperty(value = "User's email", required = true)
  @NotBlank(message = "email is required")
  @Email
  private String email;
}
