package ru.software_test.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.software_test.mantis.appmanager.ApplicationManager;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }



    public ApplicationManager getApp() {
        return app;
    }


}
