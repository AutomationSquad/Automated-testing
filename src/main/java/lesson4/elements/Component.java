package lesson4.elements;

import intefaces.IVisible;

public abstract class Component implements IVisible {

    public String name;
    public String position;

    public Component(String name) {
        this.name = name;
        position = "";
    }

    public Component() {
    }

    public void highlightComponent() {
        System.out.println(name + " is highlighted.");
    }

    public boolean isDisplayed() {
        return false;
    }
}
