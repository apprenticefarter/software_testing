package ru.software_test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck(){
        app.goTo().groups();
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
        }

    }
    @Test
    public void testGroupDelete() throws Exception {

        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count()+1, equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(deletedGroup)));
        verifyGroupListUi();


    }
    @Test(enabled = false)
    public void deleteAll() {
    app.group().deleteAll();
    }


}
