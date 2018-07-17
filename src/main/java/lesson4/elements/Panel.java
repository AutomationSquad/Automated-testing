package lesson4.elements;

public class Panel extends Container {
    private Button button;
    private TextField textField;
    private Label label;


    public Panel(Button button, TextField textField, Label label) {
        this.button = button;
        this.textField = textField;
        this.label = label;
    }
}
