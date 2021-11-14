package com.pswiderski;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.pswiderski.TestsHelper.UserType.CORRECT_HASH_CODE;
import static com.pswiderski.TestsHelper.UserType.WRONG_HASH_CODE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserHashCodeTest {

    private static final int RANDOM_USERS_COUNT = 10000;

    private static Stream<Arguments> provideArgsForInsertTest() {
        return Stream.of(
                Arguments.of(
                        "Wrong hash code test suite",
                        (Supplier<Map<User, String>>) () -> new TestsHelper().getRandomUsersMap(RANDOM_USERS_COUNT, WRONG_HASH_CODE)
                ),
                Arguments.of(
                        "Correct hash code test suite",
                        (Supplier<Map<User, String>>) () -> new TestsHelper().getRandomUsersMap(RANDOM_USERS_COUNT, CORRECT_HASH_CODE)
                )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideArgsForInsertTest")
    public void mapHashCodeInsertingTests(String description, Supplier<Map<User, String>> usersSupplier) {
        Map<User, String> users = usersSupplier.get();
        assertEquals(RANDOM_USERS_COUNT, users.size());
    }

    // declared as static to do not affect get tests overall time
    private static final Map<User, String> WRONG_HASH_CODE_USERS = new TestsHelper().getRandomUsersMap(RANDOM_USERS_COUNT, WRONG_HASH_CODE);
    private static final Map<User, String> CORRECT_HASH_CODE_USERS = new TestsHelper().getRandomUsersMap(RANDOM_USERS_COUNT, CORRECT_HASH_CODE);

    private static Stream<Arguments> provideArgsForGetTest() {
        return Stream.of(
                Arguments.of(
                        "Wrong hash code test suite",
                        (Function<User, User>) user -> UserWithWrongHashCode.builder()
                                .username(user.getUsername())
                                .age(user.getAge())
                                .id(user.getId())
                                .build(),
                        (Supplier<Map<User, String>>) () -> WRONG_HASH_CODE_USERS
                ),
                Arguments.of(
                        "Correct hash code test suite",
                        (Function<User, User>) user -> UserWithCorrectHashCode.builder()
                                .username(user.getUsername())
                                .age(user.getAge())
                                .id(user.getId())
                                .build(),
                        (Supplier<Map<User, String>>) () -> CORRECT_HASH_CODE_USERS
                )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideArgsForGetTest")
    public void mapHashCodeGetTest(String description, Function<User, User> usersCopier, Supplier<Map<User, String>> usersSupplier) {
        Map<User, String> users = usersSupplier.get();
        List<User> keysAsArray = new ArrayList<>(users.keySet());
        Random r = new Random(7);
        for (int i = 0; i < 20_000; i++) {
            User sampleUserToGet = keysAsArray.get(r.nextInt(keysAsArray.size()));
            User sampleUserToGetCopy = usersCopier.apply(sampleUserToGet);
            String id = users.get(sampleUserToGetCopy);
            assertEquals(id, sampleUserToGet.getId());
        }
    }


}