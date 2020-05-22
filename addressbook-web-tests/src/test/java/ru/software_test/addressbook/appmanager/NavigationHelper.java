package ru.software_test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));

    }
    public void gotoGroups() {
        click(By.linkText("groups"));
    }
    public  void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

}
