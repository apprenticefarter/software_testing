package ru.software_test.restApi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class TestBase {
    public TestBase() throws IOException {
    }

    @BeforeClass
    public void init() {
        RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
    }

    @Test
    public void test() throws IOException {
        System.out.println(isIssueOpen(1));
        System.out.println(getState(1));
    }

    public boolean isIssueOpen(int id) throws IOException {
        Set<Issue> issues = getIssues(id);
        String issueStatus = issues.iterator().next().getState_name();
        return !(issueStatus.equals("Resolved"));
    }
    public  String getState(int id) throws IOException {
        Set<Issue> issues = getIssues(id);
        return issues.iterator().next().getState_name();
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    public Set<Issue> getIssues(int id) throws IOException {
        String json = RestAssured.get("https://bugify.stqa.ru/api/issues/" + id + ".json").asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
        }.getType());
    }


}
