package lesson4.elements;

public class TextArea extends TextComponent {
    private Button submitButton;
    protected int length;
    protected int height;

    public TextArea (Button submitButton, int length, int height){
        this.submitButton=submitButton;
    }
    public void inputText(){
        System.out.println("Text was inputted");
        submitButton.highlightComponent();
    }
    public void storeInputText(){
        System.out.println("Store input text.");
    }



}
