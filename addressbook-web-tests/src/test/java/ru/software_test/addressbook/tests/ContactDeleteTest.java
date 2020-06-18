package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactDeleteTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        if (app.contact().list().size() == 0) {
            app.goTo().groups();
            if (app.group().list().size() == 0) {
                app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
            }
            app.contact().create(new ContactData().withFisrtname("Joe").withMiddlename("Ivanovich")
                    .withLastname("Trump").withCompany("Missleaders").withGroup("222"));
        }

    }

    @Test
    public void testContactDelete() throws Exception {

        app.contact().returnHomePage();
        Set<ContactData> before = app.contact().allset();
        ContactData deleteContact = before.iterator().next();

        app.contact().delete(deleteContact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().allset();
        before.remove(deleteContact);

        Assert.assertEquals(before, after);
    }


}
