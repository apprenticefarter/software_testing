package ru.software_test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.software_test.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }


    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
    }

    public void initGroupCreate() {
        click(By.name("new"));
    }



    public void deleteSeclectedGroups() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public void selectGroups() {
        click(By.name("selected[]"));
    }

    public void initGroupeModification() {
        click(By.xpath("(//input[@name='edit'])[2]"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {
        initGroupCreate();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();


    }
    public void returnToGroupPage() {
        click(By.linkText("group page"));

    }
    public boolean groupExistanceCheck() {
       return isElementPresent(By.name("selected[]"));
    }
}
