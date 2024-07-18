package org.example.articale;

import java.util.Scanner;

public class ArticleService
{
    private  final  ArticleRepository repository;
    private  final Scanner scanner;
    public ArticleService(Scanner scanner){
        this.repository = new ArticleRepository();
        this.scanner = scanner;
    }

    //1. 사용자한테서 새로 생성할 Article 데이터 받기
    public void createArticle(){
        System.out.print("제목을 입력하세요: ");
        String title = scanner.nextLine();
        System.out.print("내용을 입력하세요: ");
        String content = scanner.nextLine();
        repository.create(new Article(title,content));

    }
}
