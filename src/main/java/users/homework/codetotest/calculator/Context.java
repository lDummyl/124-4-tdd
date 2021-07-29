package users.homework.codetotest.calculator;

public class Context {
    private int x;
    private int y;
    private char o;
    private State state;

    public Context() {
        state = new StateX();
        state.clear(this);
    }

    public void press(char key) {
        if(key == 'c' || key == 'C') state.clear(this);
        else if(key >= '0' && key <= '9') state.digit(this, key);
        else if(key =='+' || key =='-' ||key =='*' || key =='/')state.arithmetic(this, key);
        else if(key == '=') state.equal(this);
    }

    public int run(String keys) {
        for(char key: keys.toCharArray()) {
            press(key);
        }
        return x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getO() {
        return o;
    }

    public void setO(char o) {
        this.o = o;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Context{" +
                "x=" + x +
                ", y=" + y +
                ", o=" + o +
                ", state=" + state +
                '}';
    }
}
