package users.homework.codetotest;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

/**
 * @author chervinko <br>
 * 21.07.2021
 */
public class CalculatorTest {
    private static final Calculator calculator = new Calculator();

    @Test
    public void sum() {
        assertEquals(calculator.sum(BigDecimal.ZERO, BigDecimal.ZERO), BigDecimal.ZERO);
        assertEquals(calculator.sum(BigDecimal.ONE, BigDecimal.ZERO), BigDecimal.ONE);
        assertEquals(calculator.sum(BigDecimal.valueOf(5), BigDecimal.valueOf(5)), BigDecimal.TEN);
        assertEquals(calculator.sum(BigDecimal.valueOf(1.0005), BigDecimal.valueOf(1.0001)), BigDecimal.valueOf(2.0006));
        assertEquals(calculator.sum(BigDecimal.valueOf(50), BigDecimal.valueOf(-75)), BigDecimal.valueOf(-25));
    }

    @Test
    public void difference() {
        assertEquals(calculator.difference(BigDecimal.ZERO, BigDecimal.ZERO), BigDecimal.ZERO);
        assertEquals(calculator.difference(BigDecimal.ZERO, BigDecimal.ONE), BigDecimal.valueOf(-1));
        assertEquals(calculator.difference(BigDecimal.TEN, BigDecimal.valueOf(5)), BigDecimal.valueOf(5));
        assertEquals(calculator.difference(BigDecimal.valueOf(1.0005), BigDecimal.valueOf(0.0005)).setScale(0, RoundingMode.HALF_UP), BigDecimal.valueOf(1));
        assertEquals(calculator.difference(BigDecimal.valueOf(1), BigDecimal.valueOf(0.9995)).setScale(4, RoundingMode.HALF_UP), BigDecimal.valueOf(0.0005).setScale(4, RoundingMode.HALF_UP));
    }

    @Test
    public void multiply() {
        assertEquals(calculator.multiply(BigDecimal.ZERO, BigDecimal.ZERO), BigDecimal.ZERO);
        assertEquals(calculator.multiply(BigDecimal.TEN, BigDecimal.ZERO), BigDecimal.ZERO);
        assertEquals(calculator.multiply(BigDecimal.ONE, BigDecimal.ONE), BigDecimal.ONE);
        assertEquals(calculator.multiply(BigDecimal.ONE, BigDecimal.valueOf(-1)), BigDecimal.valueOf(-1));
        assertEquals(calculator.multiply(BigDecimal.ONE, BigDecimal.valueOf(-0)), BigDecimal.ZERO);
        assertEquals(calculator.multiply(BigDecimal.valueOf(60), BigDecimal.valueOf(60)), BigDecimal.valueOf(3600));
        assertEquals(calculator.multiply(BigDecimal.valueOf(60), BigDecimal.valueOf(-60)), BigDecimal.valueOf(-3600));
    }

    @Test
    public void division() {
        assertEquals(calculator.division(BigDecimal.ZERO, BigDecimal.ONE).setScale(0, RoundingMode.HALF_UP), BigDecimal.ZERO);
        assertEquals(calculator.division(BigDecimal.TEN, BigDecimal.ONE).setScale(0, RoundingMode.HALF_UP), BigDecimal.TEN);
        assertEquals(calculator.division(BigDecimal.TEN, BigDecimal.valueOf(2)).setScale(0, RoundingMode.HALF_UP), BigDecimal.valueOf(5));
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.division(BigDecimal.ONE, BigDecimal.ZERO);
    }

    @Test
    public void rounding() {
        assertEquals(calculator.division(BigDecimal.valueOf(147), BigDecimal.valueOf(369)), BigDecimal.valueOf(0.4).setScale(2, RoundingMode.HALF_UP));
    }
}
