package lesson6;

import lesson6.listeners.TestListener;
import lesson6.tests.JUnit5Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;


import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class TestRunner {

    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectPackage("lesson6"),
                        selectClass(JUnit5Test.class)
                )
                .filters(includeClassNamePatterns(".*Test"))
                .build();

        Launcher launcher = LauncherFactory.create();

        launcher.registerTestExecutionListeners(new TestListener());

        launcher.execute(request);
    }

}
