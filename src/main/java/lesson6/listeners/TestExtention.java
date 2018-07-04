package lesson6.listeners;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestExtention implements AfterEachCallback, AfterAllCallback {


    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("AFTER ALL FROM LISTENER");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("AFTER EACH FROM LISTENER");

    }
}
