package lesson4.elements;

import lesson4.intefaces.IVisible;

public class Label extends Component implements IVisible {

    String textToBeDisplayed;


    @Override
    public void highlightComponent(){
        System.out.println(name + " is highlighted.");
        System.out.println(name + "`s" + " text is " + textToBeDisplayed);


    }

    public void highlightComponent(String position){
        System.out.println(name + " is highlighted.");
        System.out.println(name + "`s" + " position is " + position);


    }
}
