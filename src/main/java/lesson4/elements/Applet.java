package lesson4.elements;

public class Applet extends Panel {


    public Applet(Button button, TextField textField, Label label) {
        super(button, textField, label);
    }

    public void showAppletElements(Button button, TextField textField, Label label){
        button.highlightComponent();
        textField.highlightComponent();
        label.highlightComponent();
    }
}
