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

}
