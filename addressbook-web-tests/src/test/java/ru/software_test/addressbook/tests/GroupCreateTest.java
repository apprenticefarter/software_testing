package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

public class GroupCreateTest extends TestBase {


    @Test
    public void testGroupCreate() throws Exception {

        app.getNavigationHelper().gotoGroups();
        app.getGroupHelper().initGroupCreate();
        app.getGroupHelper().fillGroupForm(new GroupData("222", "hhh", "fff"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }


}
