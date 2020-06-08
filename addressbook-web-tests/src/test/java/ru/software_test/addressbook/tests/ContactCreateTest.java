package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreateTest extends TestBase {

    @Test
    public void testContactCreate() throws Exception {
        if (!app.getGroupHelper().groupExistanceCheck()) {
            app.getGroupHelper().createGroup(new GroupData("222", "hhh", "fff"));
            app.getNavigationHelper().gotoHomePage();
        }
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreate();
        app.getContactHelper().fillContactForm(new ContactData("Joe", "Ivanovich", "Trump",
                "Missleaders", "222"), true);
        app.getContactHelper().submitContactCreate();
        app.getContactHelper().returnHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        before.add(new ContactData("Joe", "Ivanovich", "Trump",
                "Missleaders", "222"));
        Comparator<? super ContactData> byName = (c1, c2) -> c1.getFisrtname().compareTo(c2.getFisrtname());
        before.sort(byName);
        after.sort(byName);
        Assert.assertEquals(before, after);

    }


}
