package com.jos.dem.swagger.service;

import java.util.List;

import com.jos.dem.swagger.model.User;
import com.jos.dem.swagger.command.UserDto;

public interface UserService {

  List<User> getAll();
  User getByUuid(String uuid);
  User create(UserDto userDto);

}
