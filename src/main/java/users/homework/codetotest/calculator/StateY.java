package users.homework.codetotest.calculator;

public class StateY implements State{

    private boolean typing = false;

    public void clear(Context context) {
        context.setState(new StateX());
        context.getState().clear(context);
    }

    public void digit(Context context, char key) {
        if(!typing) {
            context.setY(0);
            typing = true;
        }
        context.setY(context.getY() * 10 + Character.getNumericValue(key));
    }

    public void arithmetic(Context context, char key) {
        equal(context);
        context.getState().arithmetic(context, key);
    }

    public void equal(Context context) {
        context.setState(new StateAnswer());
        context.getState().equal(context);
    }
}
