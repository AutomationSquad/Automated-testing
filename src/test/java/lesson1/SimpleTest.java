package lesson1;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroShouldThrowException() {
        int a = 100;
        int b = 0;
        int i = a / b;
    }

    @Test
    public void subtractionDouble() {
        double c = 2.01;
        double f = 1;
        double g = c-f;
        Assert.assertTrue("\nExpected:\t1.01\nActual:\t\t"+g,g==1.01);
    }

    @Test
    public void subtractionFloat() {
        float c = 2.01f;
        float f = 1f;
        float g = c-f;
        Assert.assertTrue("\nExpected:\t1.01\nActual:\t\t"+g,g==1.01);
    }

    @Test
    public void name() {
        Assert.assertEquals(4, sum(1,3));
    }

    private int sum(int a, int b){
        return (a+b);
    }


}
