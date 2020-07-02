package ru.software_test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.Contacts;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import java.io.File;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDelFromGroup extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        File photo = new File("src/test/resources/new.png");
        if (app.db().contacts().size() == 0) {
            app.goTo().groups();
            if (app.db().groups().size() == 0) {
                app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
            }
            ContactData newContact = new ContactData().withFisrtname("Joe").withMiddlename("Ivanovich")
                    .withLastname("Trump").withCompany("Missleaders").withPhoto(photo);
            app.contact().create(newContact);
        }

    }

    @Test
    public void testContactDelFromGroup() throws Exception {
        File photo = new File("src/test/resources/new.png");

        app.goTo().homePage();
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        ContactData modifyContact = before.iterator().next();
        if (modifyContact.getGroups().size() < 1) {
            app.contact().create(new ContactData().withFisrtname("Joe").withMiddlename("Ivanovich")
                    .withLastname("Trump").withCompany("Missleaders").withPhoto(photo).inGroup(groups.iterator().next()));
            app.goTo().homePage();
            before = app.db().contacts();
            Iterator<ContactData> iter = before.iterator();
            while (iter.hasNext() && modifyContact.getGroups().size() < 1) {
                modifyContact = iter.next();

            }

        }

        GroupData modGroup = modifyContact.getGroups().iterator().next();
        app.contact().delGroup(modifyContact, modGroup);
        Contacts after = app.db().contacts();
        app.contact().GetHomeUrl();
        assertThat(app.contact().count(), equalTo(before.size()));
        assertThat(before.withOut(modifyContact).withAdded(new ContactData().withId(modifyContact.getId())
                .withFisrtname(modifyContact.getFirstname()).withMiddlename(modifyContact.getMiddlename())
                .withLastname(modifyContact.getLastname()).withCompany(modifyContact.getCompany())
                .withPhoto(modifyContact.getPhoto())), equalTo(after));
        verifyContactListUi();
    }




}
