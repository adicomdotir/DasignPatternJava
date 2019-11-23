package ir.adicom.dp.template;

public abstract class BasicEngineering {
    public void study() {
        math();
        physics();
        additionalStudy();
    }

    protected abstract void additionalStudy();

    private void physics() {
        System.out.println("Physics");
    }

    private void math() {
        System.out.println("Math");
    }
}
