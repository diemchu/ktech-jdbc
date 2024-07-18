package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // 연결하는 어떤 DB를 사용하는지를 정해주는 연결 주소
        String connectionString = "jdbc:sqlite:db.sqlite";
        try (Connection connection = DriverManager.getConnection(connectionString);) {
            System.out.println("Connection Success!!!");
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


//            String insertSql = """
//                    INSERT INTO user(username,password)
//                    VALUES ('%s','%s');
//                    """;
//            Scanner scanner = new Scanner(System.in);
////            System.out.print("input username: ");
//            String username  = scanner.nextLine();
//            System.out.print("input user password: ");
//            String password = scanner.nextLine();
//
//            statement.execute(String.format(insertSql,username,password));




//            executeQuery()
//                    - SELECT를 이용할때 사용
//            executeUpdate()
//                    - 데이터의 구조를 바꿀때 사용
//            execute()
//                    - 결과를 정확히 알지 못할때 대신


            //////////////////
            ResultSet result = statement.executeQuery("""
                    SELECT * FROM user;
                    """);
            while (result.next()) {
                int id = result.getInt(1);
                String username = result.getString("username");
                String password = result.getString("password");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String email = result.getString("email");

                System.out.println(String.format("%d: %s ,%s ,%s ,%s ,%s.",
                        id, username, password, first_name, last_name, email
                ));
            }

            // updater
            String updateQuery = """
                    UPDATE user
                    SET first_name = 'Alexander'
                    WHERE email like "%@gmail.com";
                    """;
            // execute update 는 변경된 갯수를 반환한다
            int count = statement.executeUpdate(updateQuery);
            System.out.println("count = " + count);

            String selectSql = "select * from user where id = %s;";
            String input ="1 OR 1 = 1";
            // 모든 데이터를 가져온다
            // select * from user where id = 1 or 1 = 1; where 항상 true 이니깐
            // 1; DROP TABLE user //table se bi xoa het

            statement.executeQuery(String.format(selectSql,input));

            // statement 안전하지 않다
            System.out.println("PreparedStatement");
            String targetSal = "select * from user where id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(targetSal);
            preparedStatement.setInt(1,100);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet.getString("first_name"));

            //ddl 할때 Statement 쎠야함
            // insert, create





        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}