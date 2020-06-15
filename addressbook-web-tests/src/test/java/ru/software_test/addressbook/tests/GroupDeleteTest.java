package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupDeleteTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck(){
        app.goTo().groups();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData("222", "hhh", "fff"));
        }

    }
    @Test
    public void testGroupDelete() throws Exception {

        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().select(index);
        app.group().deleteSeclected();
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(before.size(), after.size() + 1);

        before.remove(index);
        Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);

    }

}
