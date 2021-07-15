package users.homework.codetotest;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class LagrangeInterpolatorTest {

    @Test
    public void getY_quadratic_function_1() {
        LagrangeInterpolator li = getLagrangeInterpolator();
        float x = 3f;
        assertEquals(3f, li.getY(x), 0.001f);
    }

    private LagrangeInterpolator getLagrangeInterpolator() {
        LagrangeInterpolator lagrangeInterpolator = new LagrangeInterpolator();
        List<Point> points = Stream.of(new Point(0f, 0f),
                new Point(1f, 1f),
                new Point(2f, 2f))
                .collect(Collectors.toList());
        lagrangeInterpolator.setPoints(points);
        return lagrangeInterpolator;
    }
}