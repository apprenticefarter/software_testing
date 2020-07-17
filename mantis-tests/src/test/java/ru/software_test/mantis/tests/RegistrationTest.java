package ru.software_test.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.software_test.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class RegistrationTest extends TestBase {
   // @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {

        long now = System.currentTimeMillis();
        String email = "user" + now + "@localhost";
        String user = "user" + now;
        String password = "password";
        app.james().createUser(user,password);
        app.registration().start(user, email);
        List<MailMessage>  mailMessages = app.james().waitForMail(user,password,60000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
       assertTrue(app.newSession().login(user,password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter(m -> m.to.equals(email)).findAny().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
       return regex.getText(mailMessage.text);

    }

   // @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}