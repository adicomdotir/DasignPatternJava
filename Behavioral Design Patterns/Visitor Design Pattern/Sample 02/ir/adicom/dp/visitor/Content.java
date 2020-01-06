package ir.adicom.dp.visitor;

public class Content {
    private int data = 0;

    public Content(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void accept(ContentVisitor contentVisitor) {
        contentVisitor.visit(this);
    }
}
