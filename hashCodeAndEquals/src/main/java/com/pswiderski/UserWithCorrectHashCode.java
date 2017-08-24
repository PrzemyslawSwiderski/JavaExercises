package com.pswiderski;

import lombok.Data;

@Data
public class UserWithCorrectHashCode implements User{

  private String id;

  private String username;

  private Integer age;

}
