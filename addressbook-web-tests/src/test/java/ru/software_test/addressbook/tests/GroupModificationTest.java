package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroups();
        if (! app.getGroupHelper().groupExistanceCheck()){
            app.getGroupHelper().createGroup(new GroupData("222", "hhh", "fff"));
        }
        app.getGroupHelper().selectGroups();
        app.getGroupHelper().initGroupeModification();
        app.getGroupHelper().fillGroupForm(new GroupData("777", null, null));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

    }
}
