package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreateTest extends TestBase {


    @Test
    public void testGroupCreate() throws Exception {

        app.goTo().groups();
        List<GroupData> before = app.group().list();
        app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
        List<GroupData> after = app.group().list();

        int maxid = after.stream().max((o1,o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
        before.add(new GroupData().withId(maxid).withName("222").withHeader("hhh").withFooter("fff"));
        Assert.assertEquals(new HashSet<>(before),  new HashSet<>(after));

    }




}
