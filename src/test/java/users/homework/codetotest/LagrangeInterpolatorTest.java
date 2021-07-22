package users.homework.codetotest;

import org.junit.Test;

import java.io.IOException;

public class LagrangeInterpolatorTest {

    @Test
    public void testValidPoints() throws IOException {
        UniversalTest universalTest = new UniversalTest(LagrangeInterpolator::new);
        universalTest.testValidPoints();
    }

    @Test
    public void testInvalidPoints() throws IOException {
        UniversalTest universalTest = new UniversalTest(LagrangeInterpolator::new);
        universalTest.testInvalidPoints();
    }
}