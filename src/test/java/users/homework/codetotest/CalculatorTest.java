package users.homework.codetotest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void Test1() {
        int a = 1;
        int b = 2;
        Assert.assertTrue((a + b) == Calculator.sum(a, b));
    }

    @Test(expected = RuntimeException.class)
    public void Test2() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        Assert.assertTrue((a+b) == Calculator.sum(a,b));
    }

    @Test(expected = RuntimeException.class)
    public void Test3() {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        Assert.assertTrue((a+b) == Calculator.sum(a,b));
    }


}