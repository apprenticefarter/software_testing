package ru.software_test.addressbook;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase {
    @Test
    public void testUntitledTestCase() throws Exception {
        gotoGroups();
        selectGroups();
        deleteSeclectedGroups();
        returnToGroupPage();
    }

}
