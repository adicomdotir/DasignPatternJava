package ir.adicom.dp.visitor;

public class AddVisitor implements ContentVisitor {
    @Override
    public void visit(Content content) {
        int data = content.getData();
        content.setData(data + 150);
    }
}
