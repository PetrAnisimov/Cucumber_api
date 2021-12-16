package service;

import api.Article;

import java.util.List;

public interface ArticlesService {
    //возвращает список артиклов
    List<Article> getArticles(String url);
}
