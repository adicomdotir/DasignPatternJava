package ir.adicom.dp.state.sample1;

public class ConcreteStateA extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteClassB());
    }
}
