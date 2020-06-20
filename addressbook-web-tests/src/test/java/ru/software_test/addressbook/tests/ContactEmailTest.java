package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase {
    @Test
    public void testContactEmails() {
        app.goTo().homePage();
        ContactData contact = app.contact().allset().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);
        assertThat(contact.getAllEmails(), equalTo(merged(contactInfoFromEditForm)));

    }

    public static String merged(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).
                stream().filter((s -> !s.equals("")))
                .map(ContactEmailTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String email) {
        return email.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
