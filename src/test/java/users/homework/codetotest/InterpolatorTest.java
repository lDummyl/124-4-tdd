package users.homework.codetotest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class InterpolatorTest {

    private List<Point> points;
    private List<Interpolator> interpolators;

    @Before
    public void init(){
        points = new ArrayList<>();
        points.add(new Point(1.1f, 10.6f));
        points.add(new Point(1.7f, 15.2f));
        points.add(new Point(3.0f, 20.3f));

        interpolators = new ArrayList<>();
        interpolators.add(new LagrangeInterpolator());
        interpolators.add(new NewtonInterpolator());
    }

    @Test
    public void getYQuadraticFunctionTrue() {
        for (Interpolator interpolator : interpolators) {
            interpolator.setPoints(points);
            assertEquals(18.381378, interpolator.getY(2.3f), 0.01f);
            assertEquals(12.290958, interpolator.getY(1.3f), 0.01f);
            assertEquals(-42.26284, interpolator.getY(-2.3f), 0.01f);
        }
    }

    @Test
    public void getYQuadraticFunctionFalse() {
        for (Interpolator interpolator : interpolators) {
            interpolator.setPoints(points);
            assertNotEquals(1, interpolator.getY(2.3f));
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkArrayIndexOutOfBoundsException() {
        for (Interpolator interpolator : interpolators) {
            interpolator.setPoints(Collections.emptyList());
            assertEquals(0, interpolator.getY(0),0f);
        }
    }

    @Test(expected = NullPointerException.class)
    public void checkNullPointerException() {
        for (Interpolator interpolator : interpolators) {
            List<Point> list = null;
            interpolator.setPoints(list);
            assertEquals(0, interpolator.getY(0),0f);
        }
    }
}