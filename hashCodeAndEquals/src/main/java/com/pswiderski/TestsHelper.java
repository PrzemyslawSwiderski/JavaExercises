package com.pswiderski;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import lombok.Getter;

public class TestsHelper {

  private long userId = 1;

  @Getter
  private User userToFindFromLastGetRandomUsersMethod;

  public User getRandomUser(String userType) {

    User user;

    switch (userType.toUpperCase()) {
      case "USERWITHWRONGHASHCODE":
        user = new UserWithWrongHashCode();
        break;
      case "USERWITHCORRECTHASHCODE":
        user = new UserWithCorrectHashCode();
        break;
      default:
        throw new IllegalArgumentException("Not supported userType");
    }

    setUserRandomFields(user);

    return user;
  }

  private void setUserRandomFields(User user) {
    user.setId(Long.toString(userId));
    user.setUsername("user" + Long.toString(userId));
    user.setAge(new Random().nextInt(80));
    userId++;
  }


  public Map<User, String> getRandomUsersMap(int howMany, int userToFindIndex, String userType) {

    Map<User, String> users = new HashMap<>();

    for (int i = 0; i < howMany; i++) {
      User randomUser = getRandomUser(userType);
      users.put(randomUser, randomUser.getId());
      if (userToFindIndex == i) {
        userToFindFromLastGetRandomUsersMethod = randomUser;
      }
    }

    return users;
  }

  public static class AvgResultCounter {

    private static long resultsNumber = 0;

    private static long timeSumInMilliseconds = 0;

    public static double getAverageTime() {
      return timeSumInMilliseconds / resultsNumber;
    }

    public static void addResult(long result) {
      timeSumInMilliseconds += result;
      resultsNumber++;
    }

    public static void resetCounter() {
      resultsNumber = 0;
      timeSumInMilliseconds = 0;
    }

  }

}
