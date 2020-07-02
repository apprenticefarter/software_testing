package ru.software_test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.Contacts;
import ru.software_test.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        if (app.db().contacts().size() == 0) {
            app.goTo().groups();
            if (app.db().groups().size() == 0) {
                app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
            }
            File photo = new File("src/test/resources/new.png");
            app.contact().create(new ContactData().withFisrtname("Joe").withMiddlename("Ivanovich")
                    .withLastname("Trump").withCompany("Missleaders").withPhoto(photo));
        }

    }

    @Test
    public void testContactModification() throws Exception {
        File photo = new File("src/test/resources/new.png");

        app.contact().returnHomePage();
        Contacts before = app.db().contacts();
        ContactData modifyContact = before.iterator().next();
        app.contact().modify(modifyContact,new ContactData().withFisrtname("Raul").withLastname("Edvard")
                .withCompany("skype").withPhoto(photo));
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(before.withOut(modifyContact).withAdded(new ContactData().withId(modifyContact.getId()).withFisrtname("Raul")
                .withLastname("Edvard").withCompany("skype").withPhoto(photo)), equalTo(after));

    }


}
