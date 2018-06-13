package lesson4.elements;

import intefaces.IClickable;

public class CheckboxGroup implements IClickable {
    protected String name;
    protected String position;
    protected boolean status;

    public CheckboxGroup(String name, String position, boolean status) {
        this.name = name;
        this.position = position;
        this.status = status;
    }

    @Override
    public void click(){
        System.out.println(name + " was clicked.");
        System.out.println(name + "`s" + " status is " + status);
    }
}
