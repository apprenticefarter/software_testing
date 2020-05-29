package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

public class ContactCreateTest extends TestBase {

    @Test
    public void testContactCreate() throws Exception {
        if (! app.getGroupHelper().groupExistanceCheck()){
            app.getNavigationHelper().gotoGroups();
            app.getGroupHelper().createGroup(new GroupData("222", "hhh", "fff"));
        }
        app.getContactHelper().initContactCreate();
        app.getContactHelper().fillContactForm(new ContactData("Joe", "Ivanovich", "Trump",
                "Missleaders","222"),true);
        app.getContactHelper().submitContactCreate();
        app.getContactHelper().returnHomePage();
    }



}
