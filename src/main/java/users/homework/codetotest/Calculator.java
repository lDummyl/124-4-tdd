package users.homework.codetotest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chervinko <br>
 * 21.07.2021
 */
public class Calculator {
    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public BigDecimal difference(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    public BigDecimal division(BigDecimal a, BigDecimal b) throws ArithmeticException {
        return a.divide(b, SCALE, ROUNDING_MODE);
    }
}
