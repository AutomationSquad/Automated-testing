package lesson6.tests;


import lesson6.listeners.TestExtention;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(TestExtention.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnit5TestSecond extends BaseTest{

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

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(4);
        ints.add(2);
        ints.add(15);

        for (Integer i : ints) {

        }

        List<Integer> collect = ints.stream().filter(i -> {
            if (i > 5) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

}
