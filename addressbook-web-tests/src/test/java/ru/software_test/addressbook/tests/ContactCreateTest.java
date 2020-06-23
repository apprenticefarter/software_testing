package ru.software_test.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.Contacts;
import ru.software_test.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {

            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
        }.getType());
        return contacts.stream().map(g -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreate(ContactData contact) throws Exception {

        app.goTo().homePage();
        Contacts before = app.contact().allset();
        File photo = new File("src/test/resources/new.png");
        app.contact().create(contact.withPhoto(photo));
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().allset();
        int max = after.stream().mapToInt((c) -> c.getId()).max().getAsInt();
        assertThat(after, equalTo(before.withAdded(contact.withId(max))));
    }




}
