package lesson6.tests;


import lesson6.listeners.TestExtention;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit5Test extends BaseTest {


    private List list = new ArrayList();

    static Stream<Arguments> params() {
        return Stream.of(
//                Arguments.of(new Random().nextInt(), 2, 5),
                Arguments.of(1, 2, 3)
        );
    }


    @ParameterizedTest
    @MethodSource("params")
    void testSum2(int first, int second, int expectedResult) {
//        assertEquals(first + second, expectedResult, "Wrong sum");
        System.out.println(first + second);
    }
}
