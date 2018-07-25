package js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JSActions {
    static WebDriver driver;

    public JSActions(WebDriver driver) {
        this.driver = driver;
    }

    public  void openNewTab() {
        jsExecute("window.open()");
    }

    public  WebElement scrollToElement(WebElement element) {
        int y;
        try {
            jsExecute("arguments[0].scrollIntoView(true);",
                    element);
            y = element.getLocation().getY();
        } catch (StaleElementReferenceException e) {
            y = element.getLocation().getY();
        }
        scroll(y - 50);
        return element;
    }

    public  void scroll(int y) {
        jsExecute(String.format("scroll(0, %d);", y));
    }

    public  WebElement setText(String value, WebElement element) {
        jsExecute(String.format("arguments[0].value = '%s';",value),element);
        return element;
    }

    public  WebElement jsClick(WebElement element) {
        jsExecute("arguments[0].click();",element);
        return element;
    }

    public  WebElement setAttribute(String name, String value, WebElement element) {
        jsExecute("arguments[0].setAttribute('" + name + "','" + value + "');",element);
        return element;
    }

    public  WebElement higlight(String color, WebElement element) {
        jsExecute("arguments[0].style.border='3px dashed " + color + "';",element);
        return element;
    }

    public  WebElement higlightRed(WebElement element) {
        return higlight("red",element);
    }

    private  void jsExecute(String script, Object... args){
        ((JavascriptExecutor) driver).executeScript(script, args);
    }

}
