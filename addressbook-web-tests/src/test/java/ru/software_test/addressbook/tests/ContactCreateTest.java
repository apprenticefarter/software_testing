package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreateTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        app.goTo().groups();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
            app.goTo().homePage();
        }

    }
    @Test
    public void testContactCreate() throws Exception {

        app.goTo().homePage();
        Set<ContactData> before = app.contact().allset();
        app.contact().create(new ContactData().withFisrtname("Joe").withMiddlename("Ivanovich")
                .withLastname("Trump").withCompany("Missleaders").withGroup("222"));
        Set<ContactData> after = app.contact().allset();
        int max = after.stream().mapToInt((c) -> c.getId()).max().getAsInt();
        before.add(new ContactData().withId(max).withFisrtname("Joe").withMiddlename("Ivanovich")
                .withLastname("Trump").withCompany("Missleaders").withGroup("222"));

        Assert.assertEquals(before, after);

    }




}
