package ru.software_test.mantis.appmanager;

import org.openqa.selenium.By;

public class ResetHelper extends HelperBase {
    private int id;

    public ResetHelper(ApplicationManager app) {
        super(app);

    }

    public void logIn(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "login_page.php");
        type(By.name("username"), username);
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public void navigateToUsers() {
        click(By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/a/span"));
        click(By.linkText("Manage Users"));

    }

    public void resetPassUserById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", id))).click();
        wd.findElement(By.xpath("//input[@value='Reset Password']")).click();
    }


}
