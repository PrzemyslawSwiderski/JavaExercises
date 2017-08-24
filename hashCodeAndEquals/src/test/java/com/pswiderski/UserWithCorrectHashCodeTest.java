package com.pswiderski;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class UserWithCorrectHashCodeTest {

  @Test
  public void mapHashCodeInsertingTest() {

    TestsHelper testHelper = new TestsHelper();

    long timeBefore = System.currentTimeMillis();

    Map<User, String> users =
        testHelper.getRandomUsersMap(20000, 17500, "UserWithCorrectHashCode");

    long timeAfter = System.currentTimeMillis();

    long timeDifference = timeAfter - timeBefore;

    log.info("Inserting time: " + timeDifference);

    Assert.assertTrue(users.size() == 20000);
  }

}