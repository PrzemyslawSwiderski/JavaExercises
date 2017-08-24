package com.pswiderski;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class UserWithWrongHashCodeTest {

  @Test
  public void mapHashCodeInsertingTest() {

    TestsHelper testHelper = new TestsHelper();

    long timeBefore = System.currentTimeMillis();

    Map<User, String> users =
        testHelper.getRandomUsersMap(20000, 17500, "UserWithWrongHashCode");

    long timeAfter = System.currentTimeMillis();

    long timeDifference = timeAfter - timeBefore;

    log.info("Inserting time: " + timeDifference);

    Assert.assertTrue(users.size() == 20000);
  }

}