package users.homework.codetotest;

import org.junit.Test;

import java.io.IOException;

public class LagrangeInterpolatorTest {

    @Test
    public void testValidPoints() throws IOException {
        TestProvider test = new TestProvider(LagrangeInterpolator::new);
        test.testValidPoints();
    }

    @Test
    public void testInvalidPoints() throws IOException {
        TestProvider test = new TestProvider(LagrangeInterpolator::new);
        test.testInvalidPoints();
    }
}