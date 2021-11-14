package com.pswiderski;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
@Data
public class UserWithCorrectHashCode implements User {

    private String id;

    private String username;

    private Integer age;

}
