package at.lesson1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calc = new Calculator();

    @Test
    public void testPlus() {
        assertEquals(4, calc.plus(2, 2));
        assertEquals(10, calc.plus(1, 9));
        assertEquals("Error message", -3, calc.plus(2, -5));
    }

    @Test
    public void testMinus() {
        assertEquals(2, calc.minus(6, 4));
        assertEquals(10, calc.minus(15, 5));
        assertEquals(5, calc.minus(15, 10));
    }

    @Test
    public void testMultiplication() {
        assertEquals(3, 1, 3);
        assertEquals(6, 3, 3);
        assertEquals("Error message", 1, 5);
    }

    @Test
    public void testDivision() {
        assertEquals(2, 14, 7);
        assertEquals(10, 100, 10);
        assertEquals(-5, -25, 10);
    }
}
