package com.pswiderski;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestsHelper {

    public enum UserType {
        WRONG_HASH_CODE, CORRECT_HASH_CODE
    }

    private long userId = 1;

    public User getRandomUser(UserType userType) {

        User user;

        switch (userType) {
            case WRONG_HASH_CODE:
                user = UserWithWrongHashCode.builder().build();
                break;
            case CORRECT_HASH_CODE:
                user = UserWithCorrectHashCode.builder().build();
                break;
            default:
                throw new IllegalArgumentException("Not supported userType");
        }

        setUserRandomFields(user);

        return user;
    }

    private void setUserRandomFields(User user) {
        user.setId(Long.toString(userId));
        user.setUsername("user" + userId);
        user.setAge(new Random().nextInt(80));
        userId++;
    }


    public Map<User, String> getRandomUsersMap(int howMany, UserType userType) {

        Map<User, String> users = new HashMap<>();

        for (int i = 0; i < howMany; i++) {
            User randomUser = getRandomUser(userType);
            users.put(randomUser, randomUser.getId());
            users.get(randomUser);
        }

        return users;
    }

}
