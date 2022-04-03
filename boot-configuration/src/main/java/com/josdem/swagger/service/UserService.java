package com.josdem.swagger.service;

import java.util.List;

import com.josdem.swagger.model.User;
import com.josdem.swagger.command.UserDto;

public interface UserService {

  List<User> getAll();
  User getByUuid(String uuid);
  User create(UserDto userDto);

}
