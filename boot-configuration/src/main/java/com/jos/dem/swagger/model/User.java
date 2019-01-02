package com.jos.dem.swagger.model;

public class User {

  private String uuid;
  private String name;
  private String email;

  public User(){
    super();
  }

  public User(String uuid, String name, String email){
    this.uuid = uuid;
    this.name = name;
    this.email = email;
  }

}

