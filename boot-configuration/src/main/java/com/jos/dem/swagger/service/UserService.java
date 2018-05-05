package com.jos.dem.swagger.service;

import com.jos.dem.swagger.model.User;
import com.jos.dem.swagger.command.UserCommand;

public interface UserService {

  User getByUuid(String uuid);
  User create(UserCommand command);

}
