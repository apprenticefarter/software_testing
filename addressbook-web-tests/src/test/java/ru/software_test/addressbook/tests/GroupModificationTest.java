package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        app.getNavigationHelper().gotoGroups();

        if (!app.getGroupHelper().groupExistanceCheck()) {
            app.getGroupHelper().createGroup(new GroupData("222", "hhh", "fff"));
        }

    }

    @Test
    public void testGroupModification() {

        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroups(before.size() - 1);
        app.getGroupHelper().initGroupeModification();
        app.getGroupHelper().fillGroupForm(new GroupData("777", null, null));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        int id = before.get(before.size() - 1).getId();
        before.remove(before.size() - 1);
        before.add(new GroupData(id, "777", null, null));
        Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);

        Assert.assertEquals(before, after);

    }
}
