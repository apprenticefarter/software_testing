package ru.software_test.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase {

        @Test
        public void testContactDelete() throws Exception {
            app.getContactHelper().chooseContact();
            app.getContactHelper().initDelete();

        }
}
