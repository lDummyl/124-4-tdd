package users.homework.codetotest;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewtonInterpolatorTest extends TestCase {

    @Test
    public void testGetY() {
        NewtonInterpolator ni = getNewInterpolator();
        float x = 3f;
        assertEquals(3f, ni.getY(x), 0.001f);
    }

    private NewtonInterpolator getNewInterpolator() {
        NewtonInterpolator newtonInterpolator = new NewtonInterpolator();
        List<Point> points = Stream.of(new Point(0f, 0f),
                new Point(1f, 1f),
                new Point(2f, 2f))
                .collect(Collectors.toList());
        newtonInterpolator.setPoints(points);
        return newtonInterpolator;
    }
}