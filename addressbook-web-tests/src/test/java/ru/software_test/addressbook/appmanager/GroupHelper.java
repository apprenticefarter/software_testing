package ru.software_test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withId(id).withName(name);
            groups.add(group);
        }
        return groups;

    }
    public Groups allset() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withId(id).withName(name);
            groups.add(group);
        }
        return groups;

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


    public void deleteSeclected() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
    public void selectByID(int id) {
        wd.findElement(By.cssSelector("input[value = '"+ id +"']")).click();
    }

    public void initGroupeModification() {
        click(By.xpath("(//input[@name='edit'])[2]"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreate();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public void delete(int index) {
        select(index);
        deleteSeclected();
        returnToGroupPage();
    }
    public void delete(GroupData Group) {
        selectByID(Group.getId());
        deleteSeclected();
        returnToGroupPage();
    }

    public void modify(GroupData modify, GroupData group) {
        selectByID(modify.getId());
        initGroupeModification();
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupPage();
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));

    }

    public boolean existanceCheck() {
        click(By.linkText("groups"));
        return isElementPresent(By.name("selected[]"));
    }

    public int CountGroups() {
        return wd.findElements(By.name("selected[]")).size();
    }


}
