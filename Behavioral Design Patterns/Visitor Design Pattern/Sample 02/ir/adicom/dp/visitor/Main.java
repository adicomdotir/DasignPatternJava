package ir.adicom.dp.visitor;

public class Main {

    public static void main(String[] args) {
        Content content = new Content(130);
        System.out.println(content.getData());
        content.accept(new AddVisitor());
        System.out.println(content.getData());
        content.accept(contentVisitor -> {
            int data = contentVisitor.getData() * 5;
            contentVisitor.setData(data);
        });
    }
}
