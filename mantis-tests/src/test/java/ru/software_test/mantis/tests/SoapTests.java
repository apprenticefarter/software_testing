package ru.software_test.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.software_test.mantis.model.Issue;
import ru.software_test.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase{
    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        skipIfNotFixed(0000002);
        Set<Project> projects = app.soapHelper().getProjects();
        System.out.println(projects.size());
        for (Project project : projects)
            System.out.println(project.getName());
    }
    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soapHelper().getProjects();

        Issue issue = new Issue().withSummary("Test issue").withDescription("Test issue descriprion")
                .withProject(projects.iterator().next());
        Issue created = app.soapHelper().addIssue(issue);
        Assert.assertEquals(issue.getSummary(),created.getSummary());

    }
    @Test
    public void testResolved() throws RemoteException, ServiceException, MalformedURLException {
        System.out.println(isIssueOpen(0000002));
    }
}
