package org.example.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// ArticleDao
public class ArticleRepository {
    private Connection connection = null;

    public  ArticleRepository(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite");
        }catch (SQLException sqlException){
            throw  new RuntimeException(sqlException);
        }
    }

//    1. Article 생성
    public void create(Article article){
        String insertSql = """
                INSERT INTO article(title,content) VALUES(?,?);
                """;
        //PreparedStatement;
        try(PreparedStatement statement = connection.prepareStatement(insertSql)){
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getContent());
            int rows = statement.executeUpdate(insertSql);

        }catch (SQLException sqlException){
            throw  new RuntimeException(sqlException);
        }
    }

    //2.Article 목록 조희
    public List<Article> readAll(){
        String selectSql = """
                select * from article;
                """;
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(selectSql);
            List<Article > articles = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String content =resultSet.getString(3);
                articles.add(new Article(id,title,content));
            }
            return articles;
        }catch (SQLException sqlException){
            throw  new RuntimeException(sqlException);
        }
    }


}
