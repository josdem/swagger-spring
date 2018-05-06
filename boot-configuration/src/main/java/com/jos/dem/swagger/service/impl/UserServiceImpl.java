package com.jos.dem.swagger.service.impl;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.jos.dem.swagger.model.User;
import com.jos.dem.swagger.command.UserCommand;
import com.jos.dem.swagger.service.UserService;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

  private Map<String, User> users = new HashMap<String, User>();

  public List<User> getAll(){
    return new ArrayList<User>(users.values());
  }

  public User getByUuid(String uuid){
    return users.get(uuid) != null ? users.get(uuid) : new User();
  }

  public User create(UserCommand command){
    User user = new User(command.getUuid(), command.getName(), command.getEmail());
    users.put(command.getUuid(), user);
    return user;
  }

}
