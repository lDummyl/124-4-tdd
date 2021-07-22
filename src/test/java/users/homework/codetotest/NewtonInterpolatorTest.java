package users.homework.codetotest;

import org.junit.Test;

import java.io.IOException;

public class NewtonInterpolatorTest {

    @Test
    public void testValidPoints() throws IOException {
        TestProvider testProvider = new TestProvider(NewtonInterpolator::new);
        testProvider.testValidPoints();
    }

    @Test
    public void testInvalidPoints() throws IOException {
        TestProvider testProvider = new TestProvider(NewtonInterpolator::new);
        testProvider.testInvalidPoints();
    }
}