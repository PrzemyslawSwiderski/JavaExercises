package com.pswiderski;

import lombok.Data;

@Data
public class UserWithWrongHashCode implements User {

  private String id;

  private String username;

  private Integer age;

  @Override
  public int hashCode() {
    return -1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserWithWrongHashCode that = (UserWithWrongHashCode) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (username != null ? !username.equals(that.username) : that.username != null) {
      return false;
    }
    return age != null ? age.equals(that.age) : that.age == null;
  }

}
