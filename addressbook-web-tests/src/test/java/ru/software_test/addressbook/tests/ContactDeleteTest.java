package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.appmanager.ContactHelper;
import ru.software_test.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase {

        @Test
        public void testContactDelete() throws Exception {
            if (! app.getContactHelper().contactExistanceChek()){
                app.getContactHelper().createContact(new ContactData("Joe", "Ivanovich", "Trump",
                        "Missleaders","222"));
            }
            app.getContactHelper().chooseContact();
            app.getContactHelper().initDelete();

        }
}
