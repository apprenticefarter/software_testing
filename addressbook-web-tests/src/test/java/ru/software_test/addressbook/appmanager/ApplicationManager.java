package ru.software_test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    private  SessionHelper sessionHelper;
    private  GroupHelper groupHelper ;
    private NavigationHelper navigationHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }



    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
