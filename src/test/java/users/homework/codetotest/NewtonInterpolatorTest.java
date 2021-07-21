package users.homework.codetotest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NewtonInterpolatorTest {
    private Interpolator interpolator;

    @Before
    public void setUp() {
        interpolator = new NewtonInterpolator();
    }

    @Test
    public void getYQuadraticFunction() {
        List<Point> points = new ArrayList<>();
        for (float x = 0.25f; x < 5; x += 0.25) {
            points.add(new Point(x, FunctionUtils.quadraticFunction(2.2f, 3.3f, 4.4f, x)));
        }
        interpolator.setPoints(points);

        for (float x = 0.25f; x < 5; x += 0.25) {
            assertEquals(FunctionUtils.quadraticFunction(2.2f, 3.3f, 4.4f, x), interpolator.getY(x), 0.01);
        }
    }

    @Test
    public void getYCubicFunction() {
        List<Point> points = new ArrayList<>();
        for (float x = 0.25f; x < 5; x += 0.25) {
            points.add(new Point(x, FunctionUtils.cubicFunction(2.2f, 3.3f, 4.4f, 5.5f, x)));
        }
        interpolator.setPoints(points);

        for (float x = 0.25f; x < 5; x += 0.25) {
            assertEquals(FunctionUtils.cubicFunction(2.2f, 3.3f, 4.4f, 5.5f, x), interpolator.getY(x), 0.01);
        }
    }
}