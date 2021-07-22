package users.homework.codetotest;

import org.junit.Test;

import java.io.IOException;

public class NewtonInterpolatorTest {

    @Test
    public void testValidPoints() throws IOException {
        UniversalTest<Interpolator> universalTest = new UniversalTest<>(NewtonInterpolator::new);
        universalTest.testValidPoints();
    }

    @Test
    public void testInvalidPoints() throws IOException {
        UniversalTest<Interpolator> universalTest = new UniversalTest<>(NewtonInterpolator::new);
        universalTest.testInvalidPoints();
    }
}