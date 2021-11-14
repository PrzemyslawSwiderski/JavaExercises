package com.pswiderski;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.pswiderski.TestsHelper.UserType.WRONG_HASH_CODE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
public class UserWithWrongHashCodeTest {

    @Test
    public void mapHashCodeInsertingTests() {

        TestsHelper testHelper = new TestsHelper();

        int testNumber = 10;

        for (int i = 0; i < testNumber; i++) {
            long timeBefore = System.currentTimeMillis();

            Map<User, String> users =
                    testHelper.getRandomUsersMap(20000, 17500, WRONG_HASH_CODE);

            long timeAfter = System.currentTimeMillis();

            long timeDifference = timeAfter - timeBefore;

            log.info((i + 1) + ". test inserting time: " + timeDifference);

            TestsHelper.AvgResultCounter.addResult(timeDifference);

            assertEquals(20000, users.size());
        }

        log.info("Average Inserting time: " + TestsHelper.AvgResultCounter.getAverageTime());
    }


    @Test
    public void mapHashCodeInsertingTest() {

        TestsHelper testHelper = new TestsHelper();

        long timeBefore = System.currentTimeMillis();

        Map<User, String> users =
                testHelper.getRandomUsersMap(20000, 17500, WRONG_HASH_CODE);

        long timeAfter = System.currentTimeMillis();

        long timeDifference = timeAfter - timeBefore;

        log.info("Inserting time: " + timeDifference);

        assertEquals(20000, users.size());
    }


    @Test
    public void mapHashCodeGetTest() {

        User user1 = new UserWithWrongHashCode();
        user1.setId("1");
        user1.setAge(12);
        user1.setUsername("user1");

        User user2 = new UserWithWrongHashCode();
        user2.setId("2");
        user2.setAge(32);
        user2.setUsername("user2");

        User user3 = new UserWithWrongHashCode();
        user3.setId("3");
        user3.setAge(45);
        user3.setUsername("user3");

        User userSameAs1 = new UserWithWrongHashCode();
        userSameAs1.setId("1");
        userSameAs1.setAge(12);
        userSameAs1.setUsername("user1");

        Map<User, String> users = new HashMap<>();

        users.put(user1, "user1");
        users.put(user2, "user2");
        users.put(user3, "user3");

        assertNull(users.get(userSameAs1));

        log.info("Getting user1 result: " + users.get(userSameAs1));
    }
}