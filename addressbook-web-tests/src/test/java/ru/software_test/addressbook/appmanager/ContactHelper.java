package ru.software_test.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.software_test.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreate() {
        click(By.linkText("add new"));
    }

    public void submitContactCreate() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contact, boolean creation) {
        type(By.name("firstname"), contact.getFisrtname());
        type(By.name("middlename"), contact.getMiddlename());
        type(By.name("lastname"), contact.getLastname());
        type(By.name("company"), contact.getCompany());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
        } else
            Assert.assertFalse(isElementPresent(By.name("new_group")));

    }

    public void chooseContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void initContatctModification(int index) {
        click(By.xpath("(//img[@alt='Edit'])["+ index +"]"));

    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }
    private boolean acceptNextAlert = true;

    public void initDelete() {



        click(By.xpath("//input[@value='Delete']"));
        acceptNextAlert = true;
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));

        //wd.switchTo().alert().accept();
    }

    public void createContact(ContactData contact) {
        initContactCreate();
        fillContactForm(contact,true);
        submitContactCreate();
        returnHomePage();
    }
    public void returnHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        wd.findElement(By.linkText("home page")).click();
    }

    public boolean contactExistanceChek() {
        return isElementPresent(By.name("selected[]"));
    }


    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements =  wd.findElements(By.xpath("//table[@id=\'maintable\']/tbody/tr"));
        for (int i = 2; i < elements.size() + 1; i++) {
            String name = wd.findElement(By.xpath("//table[@id=\'maintable\']/tbody/tr[" + i + "]/td[3]")).getText();
            String lastname = wd.findElement(By.xpath("//table[@id=\'maintable\']/tbody/tr[" + i + "]/td[2]")).getText();
            ContactData contact = new ContactData(name,null,lastname,null,null);
            contacts.add(contact);
        }

        return contacts;
    }
    private String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
