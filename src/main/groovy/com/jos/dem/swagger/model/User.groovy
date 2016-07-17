package com.jos.dem.swagger.model

import org.springframework.stereotype.Component

@Component
class User {
  String uuid
  String name = 'josdem'
  String email = 'joseluis.delacruz@gmail.com'
}
