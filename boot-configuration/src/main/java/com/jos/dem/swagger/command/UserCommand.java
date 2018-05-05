package com.jos.dem.swagger.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserCommand", description="Generic command from users")
public class UserCommand {
  @ApiModelProperty(value = "User's uuid", allowableValues = "aphanumeric")
  private String uuid;
  @ApiModelProperty(value = "User's name", allowableValues = "text")
  private String name;
  @ApiModelProperty(value = "User's email", allowableValues = "email@domain")
  private String email;

  public void setUuid(String uuid){
    this.uuid = uuid;
  }

  public String getUuid(){
    return this.uuid;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getEmail(){
    return this.email;
  }

}

