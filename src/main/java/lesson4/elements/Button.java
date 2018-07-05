package lesson4.elements;

import lesson4.intefaces.IClickable;
import lesson4.intefaces.IVisible;

import java.util.Random;

public class Button extends Component implements IClickable, IVisible {


    protected String position;
    protected boolean status;
    protected String color;

    public Button(String name, String position, boolean status, String color) {
        super(name);
        this.position = position;
        this.status = status;
        this.color = color;
    }


    public Button(String name) {
        this.name = name;
    }

    @Override
    public void highlightComponent() {
        System.out.println(name + " is highlighted.");
        System.out.println(name + "`s" + " status is " + status);
        System.out.println(name + "`s" + " color is " + color);
    }

    @Override
    public void click() {
        System.out.println(name + " was  clicked");
    }

    public Button(String name, String position, boolean status) {
        this.name = name;
        this.position = position;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean isDisplayed() {
        return new Random().nextBoolean();
    }
}
