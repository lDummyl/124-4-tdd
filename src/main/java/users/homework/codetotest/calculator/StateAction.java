package users.homework.codetotest.calculator;

public class StateAction implements State{

    public void clear(Context context) {
        context.setState(new StateX());
        context.getState().clear(context);
    }

    public void digit(Context context, char key) {
        context.setState(new StateY());
        context.getState().digit(context, key);
    }

    public void arithmetic(Context context, char key) {
        context.setO(key);
    }

    public void equal(Context context) {
        context.setY(context.getX());
        context.setState(new StateAnswer());
        context.getState().equal(context);
    }
}
