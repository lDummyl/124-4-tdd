package users.homework.codetotest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LagrangeInterpolatorTest
{

    @Test
    public void getY_quadratic_function_1()
    {
        Interpolator interpolator = new LagrangeInterpolator();
        List<Point> list = new ArrayList<>();
        for(float i = 0f; i <= 10f; i += 0.5f)
        {
            list.add(new Point(i, 2.3f * i * i + 4.3f * i + 8.2f));
        }
        interpolator.setPoints(list);
        for(float i = 0.25f; i <= 10f; i += 0.5f)
        {
            assertEquals(2.3f * i * i + 4.3f * i + 8.2f,
                    interpolator.getY(i),
                    0.05f);
        }
    }
    @Test
    public void getY_quadratic_function_2()
    {
        Interpolator interpolator = new LagrangeInterpolator();
        List<Point> list = new ArrayList<>();
        for(float i = 0f; i <= 10f; i += 0.5f)
        {
            list.add(new Point(i, i * i + 4.25f * i + 8.28f));
        }
        interpolator.setPoints(list);
        for(float i = 0.25f; i <= 10f; i += 0.5f)
        {
            assertEquals(i * i + 4.25f * i + 8.28f, interpolator.getY(i), 0.1f);
        }
    }
    @Test
    public void getY_cubic_function()
    {
        Interpolator interpolator = new LagrangeInterpolator();
        List<Point> list = new ArrayList<>();
        for(float i = 0f; i <= 10f; i += 0.5f)
        {
            list.add(new Point(i, i * i * i + 3.2f * i * i + 7.72f * i + 4.32f));
        }
        interpolator.setPoints(list);
        for(float i = 0.25f; i <= 10f; i += 0.5f)
        {
            assertEquals(i * i * i + 3.2f * i * i + 7.72f * i + 4.32f,
                            interpolator.getY(i),
                            0.05f);
        }
    }
    @Test
    public void getY_sine_function()
    {
        Interpolator interpolator = new LagrangeInterpolator();
        List<Point> list = new ArrayList<>();
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
                    0.00001f);
        }
    }

    @Test
    public void getY_sine_quadratic_function()
    {
        Interpolator interpolator = new LagrangeInterpolator();
        List<Point> list = new ArrayList<>();
        for(double i = 0; i <= 360; i += 30)
        {
            list.add(new Point((float) i, quadric_sine_func(i)));
        }
        interpolator.setPoints(list);
        for(double i = 15; i <= 360; i += 30)
        {
            assertEquals(quadric_sine_func(i),
                    interpolator.getY((float) i),
                    0.01f);
        }
    }

    @Test
    public void getY_sine_4th_order_function()
    {
        Interpolator interpolator = new LagrangeInterpolator();
        List<Point> list = new ArrayList<>();
        for(double i = 0; i <= 180; i += 15)
        {
            list.add(new Point((float) i, break_it_for_sure(i)));
        }
        interpolator.setPoints(list);
        for(double i = 5; i <= 180; i += 15)
        {
            assertEquals(break_it_for_sure(i),
                        interpolator.getY((float) i),
                        0.01f);
        }
    }

    private float break_it_for_sure(double x)
    {
        return (float) (8.431f * Math.pow(Math.cos(Math.toRadians(x)), 4) + 3.483f * Math.pow(Math.sin(Math.toRadians(x)), 3) + 9.388f * Math.pow(Math.sin(Math.toRadians(x)), 2)
                + 1.333f * Math.cos(Math.toRadians(x)) + 23.1222f);
    }

    private float quadric_sine_func(double x)
    {
        return (float) (Math.pow(Math.sin(Math.toRadians(x)), 2) + 7.921f * Math.sin(Math.toRadians(x)) + 8.534f);
    }
}