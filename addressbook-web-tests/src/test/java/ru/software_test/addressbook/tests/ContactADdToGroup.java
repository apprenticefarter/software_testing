package ru.software_test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.Contacts;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactADdToGroup extends TestBase {
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
    public void testContactADdToGroup() throws Exception {
        File photo = new File("src/test/resources/new.png");

        app.goTo().homePage();
        Contacts before = app.db().contacts();
        Set<Groups> beforeGrp = before.stream().map( c -> c.getGroups()).collect(Collectors.toSet());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        beforeGrp.forEach(System.out::println);

        Groups groups = app.db().groups();
        ContactData modifyContact = new ContactData();
        GroupData modGroup = new GroupData();
        Boolean Nomatch = true;
        for (ContactData contact : before) {
            if (contact.getGroups().size() < groups.size()) {
                modifyContact = contact;
                Set<GroupData> result = new HashSet<>();
                result.addAll(groups);
                result.removeAll(modifyContact.getGroups());
                modGroup = result.iterator().next();
                Nomatch = false;
            }
        }
        if (Nomatch) {
            modGroup = groups.iterator().next();
            app.contact().create(new ContactData().withFisrtname("Joe").withMiddlename("Ivanovich")
                    .withLastname("Trump").withCompany("Missleaders").withPhoto(photo));
            app.goTo().homePage();
            before = app.db().contacts();

            Iterator<ContactData> iter = before.iterator();
            while (iter.hasNext() && iter.next().getGroups().size() > 0) {
                modifyContact = iter.next();

            }
        }

        app.contact().addGroup(modifyContact, modGroup);


        Contacts after = app.db().contacts();
        Set<Groups> afterGrp = after.stream().map( c -> c.getGroups()).collect(Collectors.toSet());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        afterGrp.forEach(System.out::println);
        //assertThat(modifyContact.getGroups().equals())
        assertThat(app.contact().count(), equalTo(before.size()));
        assertThat(before.withOut(modifyContact).withAdded(new ContactData().withId(modifyContact.getId())
                .withFisrtname(modifyContact.getFirstname()).withMiddlename(modifyContact.getMiddlename())
                .withLastname(modifyContact.getLastname()).withCompany(modifyContact.getCompany())
                .withPhoto(modifyContact.getPhoto()).inGroup(modGroup)), equalTo(after));
        verifyContactListUi();
    }


}
