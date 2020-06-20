package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {
    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().allset().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(merged(contactInfoFromEditForm)));

    }

    public static String merged(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).
                stream().filter((s -> !s.equals("")))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
