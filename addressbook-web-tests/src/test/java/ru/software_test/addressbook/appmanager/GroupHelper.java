package ru.software_test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.software_test.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id,name,null ,null);
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



    public void deleteSeclectedGroups() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public void selectGroups(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void initGroupeModification() {
        click(By.xpath("(//input[@name='edit'])[2]"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void groupCreate(GroupData group) {
        initGroupCreate();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }
    public void groupModify(int index, GroupData group) {
        selectGroups(index);
        initGroupeModification();
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupPage();
    }
    public void returnToGroupPage() {
        click(By.linkText("group page"));

    }
    public boolean groupExistanceCheck() {
        click(By.linkText("groups"));
       return isElementPresent(By.name("selected[]"));
    }

    public int CountGroups() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
