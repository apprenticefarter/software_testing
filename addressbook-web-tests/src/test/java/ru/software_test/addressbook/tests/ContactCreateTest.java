package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;

public class ContactCreateTest extends TestBase {

    @Test
    public void testContactCreate() throws Exception {
        app.getContactHelper().initContactCreate();
        app.getContactHelper().fillContactForm(new ContactData("Joe", "Ivanovich", "Trump",
                "Missleaders"));
        app.getContactHelper().submitContactCreate();
        app.getNavigationHelper().returnHomePage();
    }



}
