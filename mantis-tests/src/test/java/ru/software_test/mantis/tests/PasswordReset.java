package ru.software_test.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.software_test.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertTrue;

public class PasswordReset extends TestBase {

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter(m -> m.to.equals(email)).findAny().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);

    }

    @Test
    public void testPasswordReset() throws MessagingException, IOException {
        app.db().users();
        String user = app.db().users().get(app.db().users().size() - 1).getUsername();
        String email = app.db().users().get(app.db().users().size() - 1).getEmail();
        String password = "password";
        String newpassword = "password123";
        List<MailMessage> currentMail = app.james().getAllMail(user, password);
        app.reset().logIn(app.getProperty("web.baseLogin"), app.getProperty("web.basePassword"));
        app.reset().navigateToUsers();
        int id = app.db().users().get(app.db().users().size() - 1).getId();
        app.reset().resetPassUserById(id);


        List<MailMessage> mailMessages = app.james().waitForNewMail(currentMail.size(), user, password, 60000);


        List<MailMessage> result = mailMessages.stream().distinct().filter(currentMail::contains).collect(Collectors.toList());
        String confirmationLink = findConfirmationLink(result, email);
        app.registration().finish(confirmationLink, newpassword);
        assertTrue(app.newSession().login(user, newpassword));
    }

}
