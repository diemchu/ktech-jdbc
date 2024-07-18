package org.example.article;

public class Main
{
    public static void main(String[] args) {
        ArticleRepository articleRepository = new ArticleRepository();
        Article article = new Article("test1","tes2222");
        articleRepository.create(article);
    }
}

