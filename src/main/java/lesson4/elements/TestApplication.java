package lesson4.elements;

import lesson4.awsomeLib.AwesomeButton;
import lesson4.intefaces.IClickable;

public class TestApplication {

    public static void main(String[] args) {

//        IVisible button =
//        List<IVisible> visibles = new ArrayList();
//        visibles.add(button);
//        visibles.add(new Checkbox("checkboxname", "checkboxposition", true));
//        visibles.add(new TextField(5));
//
//        for (IVisible visible : visibles) {
//            System.out.println(visible.isDisplayed());
//        }

        AwesomeButton clickable = new AwesomeButton();

        clickable.click();
    }

    public void clickAllButtonsOnThePage() {

        IClickable ok = new AwesomeButton();
        IClickable close = new AwesomeButton();
        IClickable refund = new AwesomeButton();
        IClickable refund20 = new AwesomeButton();

        refund.click();
        System.out.println("Some logic");
        refund20.click();
        System.out.println("Some other logic");
        ok.click();
        System.out.println("Some other logic");
        close.click();

    }
}
