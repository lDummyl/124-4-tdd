package users.homework.codetotest.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContextTest {

    @Test
    public void run() {
        Context context = new Context();
        assertEquals(0,context.run("C"));
        assertEquals(5,context.run("C2+3="));
        assertEquals(2,context.run("C2="));
        assertEquals(12345,context.run("C12345="));
        assertEquals(777,context.run("C123+654="));
        assertEquals(8,context.run("C2+2*2="));
        assertEquals(10,context.run("C5+="));
        assertEquals(20,context.run("C100/5="));
        assertEquals(56,context.run("C7*8="));
        assertEquals(2025,context.run("C45*45="));
        assertEquals(57,context.run("C45-7*3/2="));
        assertEquals(0,context.run("C200*00="));
        assertEquals(40,context.run("C35*/+-*+5="));
        assertEquals(45, context.run("C5+15=30="));
    }

}