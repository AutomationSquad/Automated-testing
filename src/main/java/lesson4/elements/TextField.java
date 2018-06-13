package lesson4.elements;

import intefaces.IVisibleClickable;

public class TextField extends TextComponent implements IVisibleClickable {
    private int length;

    public TextField(int length) {
        this.length = length;
    }

    @Override
    public void displayInputText(){
        System.out.println("Display input text in one line.");
    }

    @Override
    public void click() {

    }
}
