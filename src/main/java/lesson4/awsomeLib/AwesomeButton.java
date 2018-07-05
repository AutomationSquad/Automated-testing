package lesson4.awsomeLib;

import lesson4.intefaces.IClickable;

public class AwesomeButton implements IClickable {
    @Override
    public void click() {
        System.out.println("Awesome Button was clicked!");
    }
}
