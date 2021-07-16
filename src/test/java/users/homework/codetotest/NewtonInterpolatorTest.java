package users.homework.codetotest;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class NewtonInterpolatorTest
{

    @Test
    public void getY_square()
    {
        Interpolator interpolator = new NewtonInterpolator();
        List<Point> list = new ArrayList<>();
        for(float i = -5f; i <= 5f; i += 0.5f)
        {
            list.add(new Point(i, i * i));
        }
        interpolator.setPoints(list);
        for(float i = -4.75f; i <= 4.75; i += 0.5f)
        {
            assertEquals(i * i, interpolator.getY(i), 0.0000001f);
        }
    }
    @Test
    public void getY_quadratic_function()
    {
        Interpolator interpolator = new NewtonInterpolator();
        List<Point> list = new ArrayList<>();
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
        Interpolator interpolator = new NewtonInterpolator();
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
                    0.0001f);
        }
    }
    @Test
    public void getY_sine_quadratic_function()
    {
        Interpolator interpolator = new NewtonInterpolator();
        List<Point> list = new ArrayList<>();
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
    // Этот тест ломает интерполяцию по формуле Ньютона, погрешность составляет порядка 10.
    @Test
    public void getY_sine_4th_order_function()
    {
        Interpolator interpolator = new NewtonInterpolator();
        List<Point> list = new ArrayList<>();
        for(double i = 0; i <= 360; i += 30)
        {
            list.add(new Point((float) i, break_it_for_sure(i)));
        }
        interpolator.setPoints(list);
        for(double i = 15; i <= 360; i += 30)
        {
            assertEquals(break_it_for_sure(i),
                    interpolator.getY((float) i),
                    9f);
        }
    }


    private float sine_quadratic_function(double x)
    {
        return (float) (Math.pow(Math.sin(Math.toRadians(x)), 2) + 3.48f * Math.cos(Math.toRadians(x)) + 4.31f);
    }
    private float break_it_for_sure(double x)
    {
        return (float) (8.431f * Math.pow(Math.cos(Math.toRadians(x)), 4)
                + 3.483f * Math.pow(Math.sin(Math.toRadians(x)), 3)
                + 9.388f * Math.pow(Math.sin(Math.toRadians(x)), 2)
                + 1.333f * Math.cos(Math.toRadians(x)) + 23.1222f);
    }
}