package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase {
    @Test
    public void testGroupDelete() throws Exception {
        app.getNavigationHelper().gotoGroups();
        if (! app.getGroupHelper().groupExistanceCheck()){
            app.getGroupHelper().createGroup(new GroupData("222", "hhh", "fff"));
        }
        app.getGroupHelper().selectGroups();
        app.getGroupHelper().deleteSeclectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
