package lesson5.listeners;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class TestListener implements TestExecutionListener {


    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        if (testIdentifier.isTest()) {
            System.out.println("Starting test... " + testIdentifier.getDisplayName());
        }
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        if (!testIdentifier.isTest()) return;

        if (testExecutionResult.getStatus().equals(TestExecutionResult.Status.FAILED)) {
            System.out.println("Listener: making screenshot");
        } else {
            System.out.println("Listener: doing nothing");
        }
    }
}
