package ru.software_test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        app.goTo().groups();

        if (app.group().list().size() == 0) {
            app.group().create(new GroupData("222", "hhh", "fff"));
        }

    }

    @Test
    public void testGroupModification() {

        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().modify(index, new GroupData("777", null, null));
        List<GroupData> after = app.group().list();
        int id = before.get(index).getId();
        before.remove(index);
        before.add(new GroupData(id, "777", null, null));
        Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);

        Assert.assertEquals(before, after);

    }


}
