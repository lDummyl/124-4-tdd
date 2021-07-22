package users.homework.codetotest;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterpolatorTest {
    private static final List<Interpolator> interpolators = new ArrayList<>();

    @BeforeClass
    public static void beforeClass() {
        interpolators.add(new LagrangeInterpolator());
        interpolators.add(new NewtonInterpolator());
    }

    @Test
    public void getYQuadraticFunction() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 9.9f));
        points.add(new Point(2, 19.8f));
        points.add(new Point(3, 34.1f));

        for (Interpolator interpolator : interpolators) {
            interpolator.setPoints(points);

            assertEquals(interpolator.getClass().getSimpleName(), interpolator.getY(4), 52.799995f, 0.1);
            assertEquals(interpolator.getClass().getSimpleName(), interpolator.getY(5), 75.899994f, 0.1);
            assertEquals(interpolator.getClass().getSimpleName(), interpolator.getY(6), 103.399994f, 0.1);
        }
    }
}