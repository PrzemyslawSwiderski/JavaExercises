package com.pswiderski;

import lombok.Builder;
import lombok.Data;

@Builder
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWithWrongHashCode that = (UserWithWrongHashCode) o;
        return id.equals(that.id) && username.equals(that.username) && age.equals(that.age);
    }
}
