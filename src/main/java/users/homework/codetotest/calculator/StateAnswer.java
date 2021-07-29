package users.homework.codetotest.calculator;

public class StateAnswer implements State{

    public void clear(Context context) {
        context.setState(new StateX());
        context.getState().clear(context);
    }

    public void digit(Context context, char key) {
        context.setState(new StateX());
        context.getState().digit(context,key);
    }

    public void arithmetic(Context context, char key) {
        context.setState(new StateAction());
        context.getState().arithmetic(context,key);
    }

    public void equal(Context context) {
        int answer = 0;
        switch (context.getO()) {
            case '+' : answer = context.getX() + context.getY(); break;
            case '-' : answer = context.getX() - context.getY(); break;
            case '*' : answer = context.getX() * context.getY(); break;
            case '/' : answer = context.getX() / context.getY(); break;
        }
        System.out.println("результат: "+answer);
        context.setX(answer);
    }
}
