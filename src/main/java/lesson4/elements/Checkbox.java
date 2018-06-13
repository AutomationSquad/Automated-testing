package lesson4.elements;

import intefaces.IClickable;
import intefaces.IVisible;

public class Checkbox extends CheckboxGroup implements IClickable, IVisible {

    public Checkbox(String name, String position, boolean status) {
        super(name, position, status);
    }

    @Override
    public void click() {
        System.out.println(name + " was clicked.");
        System.out.println(name + "`s" + " status is " + status);
        System.out.println(name + "`s" + " position is " + position);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
