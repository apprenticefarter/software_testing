package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreateTest extends TestBase {


    @Test
    public void testGroupCreate() throws Exception {

        app.getNavigationHelper().gotoGroups();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().initGroupCreate();
        app.getGroupHelper().fillGroupForm(new GroupData("222", "hhh", "fff"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();

        int maxid = after.stream().max((o1,o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
        before.add(new GroupData(maxid,"222", "hhh", "fff"));
        Assert.assertEquals(new HashSet<>(before),  new HashSet<>(after));

    }


}
