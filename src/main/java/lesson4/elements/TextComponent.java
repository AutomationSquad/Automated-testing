package lesson4.elements;

public class TextComponent extends Component {

    protected int size;
    protected String name;

    @Override
    public void highlightComponent() {
        System.out.println("This is  " + name + ", it's size is: " + size);
    }

    public void displayInputText(){
        System.out.println("Display input text.");
    }

}
