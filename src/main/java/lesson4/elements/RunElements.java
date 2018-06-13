package lesson4.elements;

public class RunElements {

    public static void main(String[] args) {
        Checkbox checkbox = new Checkbox("1st checkbox", "x,y", true);
        checkbox.click();

        Button button = new Button("OK button","xy", true, "red" );
        TextField textField = new TextField(50);
        Label label = new Label();
        Panel panel =  new  Panel(button, textField, label);

        button.highlightComponent();

        panel.name = "new panel" ;
        panel.elementsInside = 3;
        panel.position = "yz";
        panel.highlightComponent();

        button.name = "Applet button";
        textField.name =  "Applet textfield";
        label.name = "Applet label";

        Applet applet = new Applet(button,textField,label);
        applet.showAppletElements(button,textField,label);
        Button closeButton = new Button("Close button", "z,y", true, "red");
        Button expandButton = new Button("Expand button", "x,x",false, "gray");
        Button collapseButton = new Button("Collapse button", "x,z",false, "gray");

        Window window = new Window("Awesome window", closeButton,collapseButton,expandButton);
        window.highlightComponent();
        window.storeElements(10);
        window.collapse(collapseButton);
        window.expand(expandButton);
    }
}
