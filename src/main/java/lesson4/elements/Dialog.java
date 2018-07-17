package lesson4.elements;

public class Dialog extends Window {
    public Dialog(String name, Button closeButton, Button collapseButton, Button expandButton) {
        super(name, closeButton, collapseButton, expandButton);
    }

    public void hideDialog(){
        System.out.println("Dialog was hidden.");
    }

    @Override
    public void highlightComponent(){
        System.out.println("Dialog is selected.");
    }

}
