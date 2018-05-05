package com.jos.dem.swagger.service;

import com.jos.dem.swagger.command.UserCommand;

public interface UserService {

  private Map<User> users = new HashMap<User>();

  public User getByUuid(String uuid){
    return users.get(uuid) != null ? users.get(uuid) : new User();
  }

  public User create(UserCommand command){
    User user = new User(command.getUuid(), command.getName(), command.getEmail());
    users.put(command.getUuid(), user);
    return user;
  }

}
