package ru.software_test.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.software_test.addressbook.appmanager.ContactHelper;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactDeleteTest extends TestBase {

        @Test
        public void testContactDelete() throws Exception {
            if (! app.getContactHelper().contactExistanceChek()){
                if (! app.getGroupHelper().groupExistanceCheck()){
                    app.getGroupHelper().createGroup(new GroupData("222", "hhh", "fff"));
                }
                app.getContactHelper().createContact(new ContactData("Joe", "Ivanovich", "Trump",
                        "Missleaders","222"));
            }
            app.getContactHelper().returnHomePage();
            List<ContactData> before = app.getContactHelper().getContactList();

            app.getContactHelper().chooseContact(before.size() -1);
            app.getContactHelper().initDelete();
            app.getNavigationHelper().gotoHomePage();

            List<ContactData> after = app.getContactHelper().getContactList();
            before.remove(before.size() -1);
            Comparator<? super ContactData> byName = (c1, c2) -> c1.getFisrtname().compareTo(c2.getFisrtname());
            before.sort(byName);
            after.sort(byName);
            Assert.assertEquals(before, after);
        }
}
