package ru.software_test.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.software_test.addressbook.appmanager.ApplicationManager;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.Contacts;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(GroupCreateTest.class);

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

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test  " + m.getName() + "  with paramets:  " + Arrays.asList(p));

    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test  " + m.getName());


    }

    public ApplicationManager getApp() {
        return app;
    }

    public void verifyGroupListUi() {
       // if(Boolean.getBoolean("verifyUi")){
       Groups Dblist = app.db().groups();
       Groups UiList = app.group().allset();
        assertThat(UiList, equalTo(Dblist.stream()
                .map(g -> new GroupData().withId(g.getId()).withName(g.getName()))
                .collect(Collectors.toSet())));
       // }
    }
    public void verifyContactListUi() {
        // if(Boolean.getBoolean("verifyUi")){
        Contacts Dblist = app.db().contacts();
        Contacts UiList = app.contact().allset();
        assertThat(UiList, equalTo(Dblist.stream()
                .map(g -> new ContactData().withId(g.getId()).withFisrtname(g.getFirstname()).withLastname(g.getLastname()))
                .collect(Collectors.toSet())));
        // }
    }
}
