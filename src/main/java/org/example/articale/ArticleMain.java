package org.example.articale;

import java.util.Scanner;

public class ArticleMain {
    public static void main(String[] args) {
        // 테스트 단계
        ArticleRepository repo = new ArticleRepository();
        Scanner scanner = new Scanner(System.in);
        ArticleService articleService = new ArticleService(scanner);
        articleService.createArticle();
        for (Article article : repo.readAll()) {
            System.out.println(article);
        }
    }
}