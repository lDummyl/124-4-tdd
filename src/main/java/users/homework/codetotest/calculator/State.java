package users.homework.codetotest.calculator;

public interface State {
    void clear(Context context);
    void digit(Context context, char key);
    void arithmetic(Context context, char key);
    void equal(Context context);
}
