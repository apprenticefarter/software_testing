package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupDeleteTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck(){
        app.getNavigationHelper().gotoGroups();
        if (!app.getGroupHelper().groupExistanceCheck()) {
            app.getGroupHelper().groupCreate(new GroupData("222", "hhh", "fff"));
        }

    }
    @Test
    public void testGroupDelete() throws Exception {

        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroups(before.size() - 1);
        app.getGroupHelper().deleteSeclectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size() + 1);

        before.remove(before.size() -1);
        Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);

    }

}
