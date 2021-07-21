package users.homework.codetotest;

/**
 * @author chervinko <br>
 * 21.07.2021
 */
public final class FunctionUtils {
    /**
     * Квадратичная функция.
     */
    public static float quadraticFunction(float a, float b, float c, float x) {
        return (float) (a * Math.pow(x, 2) + b * x + c);
    }

    public static float cubicFunction(float a, float b, float c, float d, float x) {
        return (float) (a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d);
    }
}
