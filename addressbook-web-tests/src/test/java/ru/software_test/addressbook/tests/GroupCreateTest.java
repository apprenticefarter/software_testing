package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreateTest extends TestBase {


    @Test
    public void testGroupCreate() throws Exception {

        app.goTo().groups();
        Groups before = app.group().allset();
        app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
        assertThat(app.group().count(), equalTo(before.size()+1));
        Groups after = app.group().allset();
        int max = after.stream().mapToInt((g) -> g.getId()).max().getAsInt();
        assertThat(after, equalTo(before.withAdded(new GroupData()
                .withId(max).withName("222").withHeader("hhh").withFooter("fff"))));

    }
    @Test
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
