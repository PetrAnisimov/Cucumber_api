package impl;

import api.Article;
import config.TestConfig;
//import groovy.util.logging.Log4j2;
import context.RunContext;
import lombok.extern.log4j.Log4j2;
import io.restassured.response.ValidatableResponse;
import service.ArticlesService;

import java.util.ArrayList;
import java.util.List;

import static context.RunContext.RUN_CONTEXT;
import static io.restassured.RestAssured.given;

@Log4j2
public class ArticlesServiceImpl implements ArticlesService {
    TestConfig testConfig = new TestConfig();

    @Override
    public List<Article> getArticles(String url) {
        String URL = testConfig.getURL() + url;

        List<Article> articles = new ArrayList<>();

        ValidatableResponse r = given().log().everything()
                .get(URL)
                .then().log().ifError();

        RUN_CONTEXT.put("response",r);

        try {
            articles = r.extract().jsonPath().getList("articles",Article.class);
        }catch (Exception e){
            log.error("Articles request exeption" + e.getStackTrace());
        }

        return articles;
    }

}
