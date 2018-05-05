package com.jos.dem.swagger.model;

import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String uuid;
  private String name;
  private String email;

}

