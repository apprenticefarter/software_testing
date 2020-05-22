package ru.software_test.addressbook;

import org.testng.annotations.Test;

public class GroupCreateTest extends TestBase{


    @Test
    public void testGroupCreate() throws Exception {

        gotoGroups();
        initGroupCreate();
        fillGroupForm(new GroupData("222", "hhh", "fff"));
        submitGroupCreation();
        returnToGroupPage();
    }


}
