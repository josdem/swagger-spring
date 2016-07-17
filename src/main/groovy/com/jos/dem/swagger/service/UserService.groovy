package com.jos.dem.swagger.service

import org.springframework.stereotype.Service

import com.jos.dem.swagger.model.User

@Service
class UserService {

  User getByUuid(String uuid){
    new User(uuid:uuid)
  }

}
