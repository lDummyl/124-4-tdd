package users.homework.codetotest;

import org.junit.Test;

import static org.junit.Assert.*;

public class LagrangeInterpolatorTest {
    private final LagrangeInterpolator interpolator = new LagrangeInterpolator();

    @Test
    public void getY_simple_test() {
            interpolator.points.add(new Point(0, 2));
            interpolator.points.add(new Point(2, 4));
            interpolator.points.add(new Point(8, 4));

            float result = interpolator.getY(10);
            assertEquals(2f, result, 0.0f);
      }

    @Test (expected = IllegalArgumentException.class)
    public void if_nodes_are_equal() {
        interpolator.points.add(new Point(0, 2));
        interpolator.points.add(new Point(0, 4));
        interpolator.points.add(new Point(8, 4));

        interpolator.getY(10);
    }
}