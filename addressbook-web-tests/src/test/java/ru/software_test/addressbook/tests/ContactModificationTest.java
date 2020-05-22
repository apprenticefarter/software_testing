package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() throws Exception {
        app.getContactHelper().chooseContact();
        app.getContactHelper().initContatctModification();
        app.getContactHelper().fillContactForm(new ContactData("Raul", "Petrovich", "Edvard",
                "skype"));
        app.getContactHelper().submitContactUpdate();
        app.getNavigationHelper().returnHomePage();
    }
}