package com.jos.dem.swagger.service.impl;

import com.jos.dem.swagger.command.UserDto;
import com.jos.dem.swagger.model.User;
import com.jos.dem.swagger.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final Map<String, User> users = new HashMap<>();

  private Logger log = LoggerFactory.getLogger(this.getClass());

  public List<User> getAll(){
    return new ArrayList<>(users.values());
  }

  public User getByUuid(String uuid){
    return users.get(uuid) != null ? users.get(uuid) : new User();
  }

  public User create(UserDto userDto){
    User user = new User(userDto.getUuid(), userDto.getName(), userDto.getEmail());
    users.put(userDto.getUuid(), user);
    return user;
  }

}
