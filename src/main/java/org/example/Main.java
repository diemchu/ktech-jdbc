package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 연결하는 어떤 DB를 사용하는지를 정해주는 연결 주소
        String connectionString = "jdbc:sqlite:db.sqlite";
        try(Connection connection = DriverManager.getConnection(connectionString);){

            // 대이터 베이스에 sql문 (sql Statment)를 전달할 준비를 한다
            Statement statement = connection.createStatement();
//            String query = "DROP TABLE IF EXISTS user;";
//            statement.execute(query);
//
//            String crTableQuery = "CREATE TABLE user(" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "username TEXT," +
//                    "password TEXT," +
//                    "first_name TEXT," +
//                    "last_name TEXT," +
//                    "email TEXT);";
//            statement.execute(crTableQuery);

            // """ """ sql 형태
//            statement.execute("""
//                    SELECT * FROM user;
//                    """);

//            statement.execute("""
//                    INSERT INTO user(username,password,first_name,last_name,email)
//                    VALUES ('ALEX','aaa','Alex','Rod','alex@gmail.com');
//                    """);
//
//            statement.execute("""
//                    INSERT INTO user(username,password,first_name,last_name,email)
//                    VALUES ('bard','bbb','brad','Pete','brad@gmail.com');
//                    """);
//
            String insertSql = """
                    INSERT INTO user(username,password)
                    VALUES ('%s','%s');
                    """;
            Scanner scanner = new Scanner(System.in);
            System.out.print("input username: ");
            String username  = scanner.nextLine();
            System.out.print("input user password: ");
            String password = scanner.nextLine();

            statement.execute(String.format(insertSql,username,password));



            System.out.println("Connection Success!!!");
        }catch (SQLException e){
            System.err.println(e.getErrorCode());
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}