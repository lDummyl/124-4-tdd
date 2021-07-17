package users.homework.codetotest;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewtonInterpolatorTest
{
    Interpolator interpolator;
    List<Point> list;

    @BeforeEach
    public void setup()
    {
        interpolator = new NewtonInterpolator();
        list = new ArrayList<>();
    }

    @Test
    public void getY_cubic_function()
    {
        for(float i = -5f; i <= 5f; i += 0.5f)
        {
            list.add(new Point(i, i * i * i + 3f * i * i + 8f * i + 0.34f));
        }
        interpolator.setPoints(list);
        for(float i = -4.75f; i <= 4.75f; i += 0.5f)
        {
            assertEquals(i * i * i + 3f * i * i + 8f * i + 0.34f,
                    interpolator.getY(i),
                    0.0005f);
        }
    }

    @Test
    public void getY_sine_function()
    {
        for(double i = 0; i <= 360; i += 30)
        {
            list.add(new Point((float) Math.toRadians(i),
                    (float)Math.sin(Math.toRadians(i))));
        }
        interpolator.setPoints(list);
        for(double i = 15; i <= 360; i += 30)
        {
            assertEquals((float) Math.sin(Math.toRadians(i)),
                    interpolator.getY((float) Math.toRadians(i)),
                    0.0001f);
        }
    }
    @Test
    public void getY_sine_quadratic_function()
    {
        for(double i = 0; i <= 360; i += 30)
        {
            list.add(new Point((float) i, sine_quadratic_function(i)));
        }
        interpolator.setPoints(list);
        for(double i = 15; i <= 360; i += 30)
        {
            assertEquals(sine_quadratic_function(i),
                    interpolator.getY((float) i),
                    0.005f);
        }
    }

    @Test
    public void getY_sine_4th_order_function()
    {
        for(double i = 0; i <= 180; i += 15)
        {
            list.add(new Point((float) i, func_4th_order(i)));
        }
        interpolator.setPoints(list);
        for(double i = 5; i <= 180; i += 15)
        {
            assertEquals(func_4th_order(i),
                    interpolator.getY((float) i),
                    0.01f);
        }
    }

    @Test
    public void getY_quadric_tan()
    {
        for(double i = 0; i <= 180; i += 3)
        {
            list.add(new Point((float) i, tan_func(i)));
        }
        interpolator.setPoints(list);
        for(double i = 1.5; i <= 180; i += 3)
        {
            assertEquals(tan_func(i),
                    interpolator.getY((float) i),
                    0.1f);
        }
    }

    private float sine_quadratic_function(double x)
    {
        return (float) (Math.pow(Math.sin(Math.toRadians(x)), 2) + 3.48f * Math.cos(Math.toRadians(x)) + 4.31f);
    }

    private float func_4th_order(double x)
    {
        return (float) (8.431f * Math.pow(Math.cos(Math.toRadians(x)), 4)
                + 3.483f * Math.pow(Math.sin(Math.toRadians(x)), 3)
                + 9.388f * Math.pow(Math.sin(Math.toRadians(x)), 2)
                + 1.333f * Math.cos(Math.toRadians(x)) + 23.1222f);
    }

    private float tan_func(double x)
    {
        return (float) (Math.pow(Math.tan(Math.toRadians(x * 0.5)), 2) - Math.tan(Math.toRadians(x)));
    }
}