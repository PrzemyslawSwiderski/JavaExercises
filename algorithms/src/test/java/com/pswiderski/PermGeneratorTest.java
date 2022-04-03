package com.pswiderski;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PermGeneratorTest {


    private static Stream<Arguments> permTestCases() {
        return Stream.of(
                Arguments.of(
                        "Simple test case",
                        "ABC",
                        Lists.newArrayList("ABC", "BAC", "BCA", "CBA", "ACB", "CAB")
                ),
                Arguments.of(
                        "A little more complex one test case",
                        "ABCD",
                        Lists.newArrayList("ABCD",
                                "ABDC",
                                "ACBD",
                                "ACDB",
                                "ADCB",
                                "ADBC",
                                "BACD",
                                "BADC",
                                "BCAD",
                                "BCDA",
                                "BDCA",
                                "BDAC",
                                "CBAD",
                                "CBDA",
                                "CABD",
                                "CADB",
                                "CDAB",
                                "CDBA",
                                "DBCA",
                                "DBAC",
                                "DCBA",
                                "DCAB",
                                "DACB",
                                "DABC"
                        )
                )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("permTestCases")
    public void testPermGeneration(String description, String input, List<String> expected) {
        // given
        PermGenerator permGenerator = new PermGenerator();

        // then
        assertThat(permGenerator.generate(input)).containsExactlyInAnyOrderElementsOf(expected);
    }

}