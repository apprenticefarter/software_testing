package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.ContactData;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactDeleteTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        if (!app.getContactHelper().contactExistanceChek()) {
            if (!app.getGroupHelper().groupExistanceCheck()) {
                app.getGroupHelper().groupCreate(new GroupData("222", "hhh", "fff"));
            }
            app.getContactHelper().createContact(new ContactData("Joe", "Ivanovich", "Trump",
                    "Missleaders", "222"));
        }

    }

    @Test
    public void testContactDelete() throws Exception {

        app.getContactHelper().returnHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().chooseContact(before.size() - 1);
        app.getContactHelper().initDelete();
        app.getNavigationHelper().gotoHomePage();
        //WebDriverWait wait = new WebDriverWait(app.wd,30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='maintable']")));
        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size() - 1);
        Comparator<? super ContactData> byName = (c1, c2) -> c1.getFisrtname().compareTo(c2.getFisrtname());
        before.sort(byName);
        after.sort(byName);
        Assert.assertEquals(before, after);
    }
}
