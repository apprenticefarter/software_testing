package ru.software_test.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

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

public class GroupCreateTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        List<Object[]> list = new ArrayList<>();
        String xml;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
            xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class);
        List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
        return groups.stream().map(g -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<>();
        String json;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
            json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
        }
        Gson gson = new Gson();
        List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
        }.getType());
        return groups.stream().map(g -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validGroupsFromJson")
    public void testGroupCreate(GroupData group) throws Exception {
        app.goTo().groups();
        Groups before = app.db().groups();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.db().groups();
        int max = after.stream().mapToInt((g) -> g.getId()).max().getAsInt();
        assertThat(after, equalTo(before.withAdded(group.withId(max))));

    }

    @Test(enabled = false)
    public void testBadGroupCreate() throws Exception {

        app.goTo().groups();
        Groups before = app.group().allset();
        app.group().create(new GroupData().withName("222'").withHeader("hhh").withFooter("fff"));
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().allset();
        int max = after.stream().mapToInt((g) -> g.getId()).max().getAsInt();
        assertThat(after, equalTo(before));

    }


}
