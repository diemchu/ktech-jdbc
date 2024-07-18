<<<<<<<< Updated upstream:src/main/java/org/example/articale/Article.java
package org.example.articale;
========
package org.example.article;
>>>>>>>> Stashed changes:src/main/java/org/example/article/Article.java

public class Article
{
    private long id;
    private  String title;
    private String content;

    public Article(){}

    //개시글 추가할 때
    public Article(String title,String content){
        this.title = title;
<<<<<<<< Updated upstream:src/main/java/org/example/articale/Article.java
        this.content= content;
========
        this.content = content;
>>>>>>>> Stashed changes:src/main/java/org/example/article/Article.java
    }

    //데이터 불러올 떄 쓸 생성자
    public Article(long id ,String title,String content){
        this.id = id;
        this.title =title;
        this.content = content;
    }
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
