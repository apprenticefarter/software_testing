package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

public class GroupCreateTest extends TestBase {


    @Test
    public void testGroupCreate() throws Exception {

        app.gotoGroups();
        app.initGroupCreate();
        app.fillGroupForm(new GroupData("222", "hhh", "fff"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }


}
