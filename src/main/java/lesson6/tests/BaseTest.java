package lesson6.tests;

import lesson6.listeners.TestExtention;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestExtention.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {


    private String driver;

    @BeforeAll
    public void beforeClass() {
        System.out.println("BEFORE CLASS");
    }

    @BeforeEach
    public void before() {
        driver = "chrome";
    }


    @AfterEach
    public void after() {
        System.out.println("AfterEach from class");
    }

    @AfterAll
    public void afterAll() {
        System.out.println("AfterAll from class");
    }
}
