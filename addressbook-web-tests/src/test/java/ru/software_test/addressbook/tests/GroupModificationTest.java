package ru.software_test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck() {
        app.goTo().groups();

        if (app.group().allset().size() == 0) {
            app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
        }

    }

    @Test
    public void testGroupModification() {

        Groups before = app.group().allset();
        GroupData modifyGroup = before.iterator().next();
        app.group().modify(modifyGroup, new GroupData().withName("777"));
        Groups after = app.group().allset();
        assertThat(after, equalTo(before.without(modifyGroup)
                .withAdded(new GroupData().withId(modifyGroup.getId()).withName("777"))));

    }


}
