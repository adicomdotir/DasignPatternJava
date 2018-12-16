package ir.rsatm.app.gazapp.dp.decorator;

/**
 * SimpleText
 * Created by Y.P on 17/12/2018.
 */

public class SimpleText implements Text {
    @Override
    public void printText() {
        System.out.println("This is simple text.");
    }
}
