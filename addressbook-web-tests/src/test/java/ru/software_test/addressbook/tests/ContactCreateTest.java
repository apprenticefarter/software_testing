package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.Contacts;
import ru.software_test.addressbook.model.GroupData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreateTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        app.goTo().groups();
        if (app.group().allset().size() == 0) {
            app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
            app.goTo().homePage();
        }

    }
    @Test
    public void testContactCreate() throws Exception {

        app.goTo().homePage();
        Contacts before = app.contact().allset();
        app.contact().create(new ContactData().withFisrtname("Joe").withMiddlename("Ivanovich")
                .withLastname("Trump").withCompany("Missleaders").withGroup("222"));
        Contacts after = app.contact().allset();
        int max = after.stream().mapToInt((c) -> c.getId()).max().getAsInt();
        assertThat(after, equalTo(before.withAdded(new ContactData().withId(max).withFisrtname("Joe").withMiddlename("Ivanovich")
                .withLastname("Trump").withCompany("Missleaders").withGroup("222"))));
    }




}
