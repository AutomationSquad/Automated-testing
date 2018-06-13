package lesson4.elements;

public class Window extends Container {

    private Button closeButton;
    private Button collapseButton;
    private Button expandButton;

    public Window(String name, Button closeButton, Button collapseButton, Button expandButton){
        this.name = name;
        this.closeButton = closeButton;
        this.collapseButton = collapseButton;
        this.expandButton = expandButton;
    }

    @Override
    public void storeElements(int elementsInside){
        System.out.println(name + " contains " + elementsInside + " elements inside");
        closeButton.click();
        collapseButton.click();
        expandButton.click();
    }

    public void collapse(Button collapseButton){
        collapseButton.click();
        System.out.println(name + " is collapsed.");
    }

    public void expand(Button expandButton){
        expandButton.click();
        System.out.println(name + " is expanded.");
    }
}
