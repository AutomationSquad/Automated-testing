package lesson7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {


    private Cacl cacl = new Cacl();

    static Stream<Arguments> params(){
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(4, 8),
                Arguments.of(4, 16)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void test(int first, int second){
        assertEquals(cacl.add(first, second), first + second, "Wrong sum");
    }
}
