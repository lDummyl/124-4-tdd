package users.homework.codetotest;

import org.junit.Test;

import static org.junit.Assert.*;

public class LagrangeInterpolatorTest {
    private final LagrangeInterpolator interpolator = new LagrangeInterpolator();

    @Test
    public void getY_linear_test() {
            interpolator.points.add(new Point(2, 4));
            interpolator.points.add(new Point(4, 6));
            interpolator.points.add(new Point(6, 8));

            float result = interpolator.getY(8);
            assertEquals(10, result, 0.0f);
      }

    @Test
    public void getY_pow2_test() {
        interpolator.points.add(new Point(2, 4));
        interpolator.points.add(new Point(4, 16));
        interpolator.points.add(new Point(6, 36));

        float result = interpolator.getY(8);
        assertEquals(64, result, 0.0f);
    }

    @Test
    public void getY_pow3_test() {
        interpolator.points.add(new Point(2, 8));
        interpolator.points.add(new Point(4, 64));
        interpolator.points.add(new Point(6, 216));
        interpolator.points.add(new Point(8, 512));

        float result = interpolator.getY(10);
        assertEquals(1000, result, 0.0f);
    }

    @Test (expected = IllegalArgumentException.class)
    public void if_nodes_are_equal() {
        interpolator.points.add(new Point(0, 2));
        interpolator.points.add(new Point(0, 4));
        interpolator.points.add(new Point(8, 4));

        interpolator.getY(10);
    }
}