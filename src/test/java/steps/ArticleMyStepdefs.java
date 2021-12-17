package steps;

import api.Article;
import impl.ArticlesServiceImpl;
import io.cucumber.java.sl.In;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import service.ArticlesService;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

import static context.RunContext.RUN_CONTEXT;

public class ArticleMyStepdefs {
    ArticlesService articlesService = new ArticlesServiceImpl();


    @io.cucumber.java.en.Given("Get Articles {string} Request")
    public void getArticlesRequest(String url) {
        articlesService.getArticles(url);

    }

    @io.cucumber.java.en.Then("Response code is: {string}")
    public void responseCodeIs(String status) {
        ValidatableResponse response = RUN_CONTEXT.get("response",ValidatableResponse.class);
        int actualStatus = response.extract().statusCode();
        int expectedStatus = Integer.parseInt(status);

        Assert.assertEquals(actualStatus,expectedStatus);
    }
}
