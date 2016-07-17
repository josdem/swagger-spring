package com.jos.dem.swagger.service

import org.springframework.stereotype.Service

import com.jos.dem.swagger.model.User
import com.jos.dem.swagger.command.UserCommand

@Service
class UserService {

  def users = [:]

  User getByUuid(String uuid){
    users[uuid] != null ? users[uuid] : new User()
  }

  User create(UserCommand command){
    users[command.uuid] = new User(uuid:command.uuid, name:command.name, email:command.email)
  }

}

