package users.homework.codetotest.calculator;

public class StateX implements State{

    private boolean typing = false;

    public void clear(Context context) {
        context.setX(0);
        context.setY(0);
        context.setO('+');
    }

    public void digit(Context context, char key) {
        if(!typing) {
            context.setX(0);
            typing = true;
        }
        context.setX(context.getX() * 10 + Character.getNumericValue(key));
    }

    public void arithmetic(Context context, char key) {
        context.setState(new StateAction());
        context.getState().arithmetic(context, key);
    }

    public void equal(Context context) {
        context.setState(new StateAnswer());
        context.getState().equal(context);
    }
}
