package ru.software_test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.Contacts;
import ru.software_test.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        if (app.contact().allset().size() == 0) {
            app.goTo().groups();
            if (app.group().allset().size() == 0) {
                app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
            }
            app.contact().create(new ContactData().withFisrtname("Joe").withMiddlename("Ivanovich")
                    .withLastname("Trump").withCompany("Missleaders").withGroup("222"));
        }

    }

    @Test
    public void testContactModification() throws Exception {

        app.contact().returnHomePage();
        Contacts before = app.contact().allset();
        ContactData modifyContact = before.iterator().next();
        app.contact().modify(modifyContact);
        Contacts after = app.contact().allset();
        assertThat(before.withOut(modifyContact).withAdded(new ContactData().withId(modifyContact.getId()).withFisrtname("Raul")
                .withLastname("Edvard").withCompany("skype")), equalTo(after));

    }


}
