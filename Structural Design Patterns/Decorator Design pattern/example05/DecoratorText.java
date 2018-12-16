package ir.rsatm.app.gazapp.dp.decorator;

/**
 * DecoratorText
 * Created by Y.P on 17/12/2018.
 */

public class DecoratorText implements Text {

    private Text mText;

    public DecoratorText(Text mText) {
        this.mText = mText;
    }

    @Override
    public void printText() {
        mText.printText();
        System.out.println("This is bold text!");
    }
}
