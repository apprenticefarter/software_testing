package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase {
    @Test
    public void testUntitledTestCase() throws Exception {
        app.getNavigationHelper().gotoGroups();
        app.getGroupHelper().selectGroups();
        app.getGroupHelper().deleteSeclectedGroups();
        app.getNavigationHelper().returnToGroupPage();
    }

}
