package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase {
    @Test
    public void testUntitledTestCase() throws Exception {
        app.gotoGroups();
        app.selectGroups();
        app.deleteSeclectedGroups();
        app.returnToGroupPage();
    }

}
