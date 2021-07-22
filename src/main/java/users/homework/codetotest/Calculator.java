package users.homework.codetotest;

public class Calculator {

    public static int sum(int a, int b) {
        if ((a >>> 31 ^ b >>> 31) == 0) {
            if ((a >>> 31 ^ (a + b) >>> 31) == 1) {
                throw new RuntimeException("Overflow");
            }
        }
        return a + b;
    }

    public static int diff(int a, int b) {
        if (b == 0) {
            return a;
        }
        if ((a >>> 31 ^ b >>> 31) == 1) {
            if (((a >>> 31) ^ (Integer.MAX_VALUE - b) >>> 31) == 1) {
                throw new RuntimeException("Overflow");
            }
        }
        return a - b;
    }

    public static int mult(int a, int b) {
        if ((a == 0) || (b == 0)) {
            return 0;
        }
        if ((a == 1) || (b == 1)) {
            return a * b;
        }
        boolean check = (a >>> 31 ^ b >>> 31) == 0;
        a = (a ^ (a >> 31)) + (a >>> 31);
        b = (b ^ (b >> 31)) + (b >>> 31);
        if (check) {
            if (a > (Integer.MAX_VALUE / b) || b > (Integer.MAX_VALUE / a)) {
                throw new RuntimeException("Overflow_check=true");
            }
        } else {
            if (-a < (Integer.MIN_VALUE / b) || -b < (Integer.MIN_VALUE / a)) {
                throw new RuntimeException("Overflow_check=false");
            }
        }
        return a * b;
    }
}
