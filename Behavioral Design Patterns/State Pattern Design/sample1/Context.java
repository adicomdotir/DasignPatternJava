package ir.adicom.dp.state.sample1;

public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
        System.out.println(state);
    }

    public void setState(State state) {
        this.state = state;
    }
}
