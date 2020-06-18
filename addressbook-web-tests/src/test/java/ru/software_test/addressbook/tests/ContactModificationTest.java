package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

import java.util.Set;

public class ContactModificationTest extends TestBase {
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
    public void testContactModification() throws Exception {


        app.contact().returnHomePage();
        Set<ContactData> before = app.contact().allset();
        ContactData modifyContact = before.iterator().next();
        app.contact().modify(modifyContact);

        Set<ContactData> after = app.contact().allset();
        before.remove(modifyContact);
        before.add(new ContactData().withId(modifyContact.getId()).withFisrtname("Raul").withLastname("Edvard")
                .withCompany("skype"));

        Assert.assertEquals(before, after);
    }


}
