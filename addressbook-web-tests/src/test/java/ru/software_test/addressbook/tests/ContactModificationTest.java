package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() throws Exception {
        if (! app.getContactHelper().contactExistanceChek()){
            app.getContactHelper().createContact(new ContactData("Joe", "Ivanovich", "Trump",
                    "Missleaders","777"));
        }
        app.getContactHelper().chooseContact();
        app.getContactHelper().initContatctModification();
        app.getContactHelper().fillContactForm(new ContactData("Raul", null, "Edvard",
                "skype",null),false);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returnHomePage();
    }
}
