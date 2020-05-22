package ru.software_test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.software_test.addressbook.model.ContactData;

import static org.testng.Assert.assertTrue;

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

    public void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.getFisrtname());
        type(By.name("middlename"), contact.getMiddlename());
        type(By.name("lastname"), contact.getLastname());
        type(By.name("company"), contact.getCompany());
    }

    public void chooseContact() {
        click(By.name("selected[]"));
    }

    public void initContatctModification() {
        click(By.xpath("//img[@alt='Edit']"));

    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }

    public void initDelete() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

}