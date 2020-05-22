package ru.software_test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.software_test.addressbook.model.ContactData;

public class ContactHelper extends  HelperBase{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void initContactCreate() {
        wd.findElement(By.linkText("add new")).click();
    }
    public void submitContactCreate() {
        wd.findElement(By.name("submit")).click();
    }
    public void fillContactForm(ContactData contact) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contact.getFisrtname());
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contact.getMiddlename());
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contact.getLastname());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contact.getCompany());
    }
}
