package steps;

import api.Article;
import impl.ArticlesServiceImpl;
import service.ArticlesService;

import java.util.List;

public class ArticleMyStepdefs {
    ArticlesService articlesService = new ArticlesServiceImpl();


    @io.cucumber.java.en.Given("Get Articles {string} Request")
    public void getArticlesRequest(String url) {
        List<Article> articlesList = articlesService.getArticles(url);
        System.out.println(articlesList);
    }

    @io.cucumber.java.en.Then("Response code is: {string}")
    public void responseCodeIs(String status) {
    }
}
