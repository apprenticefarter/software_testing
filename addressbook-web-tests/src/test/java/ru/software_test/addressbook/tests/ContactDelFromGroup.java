package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.Contacts;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        GroupData modGroup = new GroupData();
        for (ContactData contact : before) {
            if (contact.getGroups().size() > 0) {
                modifyContact = contact;
                modGroup = modifyContact.getGroups().iterator().next();
            } else {
                modifyContact = before.iterator().next();
                modGroup = groups.iterator().next();
                app.contact().addGroup(modifyContact, modGroup);
            }
        }

        Set<GroupData> beforeDel = modifyContact.getGroups();

        app.contact().delGroup(modifyContact, modGroup);
        app.contact().GetHomeUrl();

        Contacts after = app.db().contacts();
        ContactData finalModifyContact = modifyContact;
        Set<ContactData> aaf = after.stream().filter(c -> c.equals(finalModifyContact)).collect(Collectors.toSet());
        Set<GroupData> aftreGrp = aaf.iterator().next().getGroups();

        beforeDel.remove(modGroup);
        assertThat(beforeDel,equalTo(aftreGrp));
        /*
        assertThat(app.contact().count(), equalTo(before.size()));
        assertThat(before.withOut(modifyContact).withAdded(new ContactData().withId(modifyContact.getId())
                .withFisrtname(modifyContact.getFirstname()).withMiddlename(modifyContact.getMiddlename())
                .withLastname(modifyContact.getLastname()).withCompany(modifyContact.getCompany())
                .withPhoto(modifyContact.getPhoto())), equalTo(after));
        verifyContactListUi();

         */
    }


}
