package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before = app.contact().list();
        app.contact().modify(before.size());

        List<ContactData> after = app.contact().list();
        before.remove(before.size() - 1);
        before.add(new ContactData().withFisrtname("Raul").withLastname("Edvard")
                .withCompany("skype"));
        Comparator<? super ContactData> byName = (c1, c2) -> c1.getFisrtname().compareTo(c2.getFisrtname());
        before.sort(byName);
        after.sort(byName);
        Assert.assertEquals(before, after);
    }


}
