package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification() throws Exception {
        if (!app.getContactHelper().contactExistanceChek()) {
            if (!app.getGroupHelper().groupExistanceCheck()) {
                app.getGroupHelper().createGroup(new GroupData("222", "hhh", "fff"));
            }
            app.getContactHelper().createContact(new ContactData("Joe", "Ivanovich", "Trump",
                    "Missleaders", "222"));
        }

        app.getContactHelper().returnHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContatctModification(before.size());
        app.getContactHelper().fillContactForm(new ContactData("Raul", null, "Edvard",
                "skype", null), false);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returnHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size() -1);
        before.add(new ContactData("Raul", null, "Edvard",
                "skype", null));
        Comparator<? super ContactData> byName = (c1, c2) -> c1.getFisrtname().compareTo(c2.getFisrtname());
        before.sort(byName);
        after.sort(byName);
        Assert.assertEquals(before, after);
    }
}
