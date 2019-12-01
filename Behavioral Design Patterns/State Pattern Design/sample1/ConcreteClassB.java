package ir.adicom.dp.state.sample1;

public class ConcreteClassB extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}
