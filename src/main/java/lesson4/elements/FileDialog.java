package lesson4.elements;

public class FileDialog extends Dialog {
    public FileDialog(String name, Button closeButton, Button collapseButton, Button expandButton) {
        super(name, closeButton, collapseButton, expandButton);
    }

    public void uploadFiles(Button uploadButton){
        System.out.println("Select file to  be uploaded");
        uploadButton.click();
    }
}
