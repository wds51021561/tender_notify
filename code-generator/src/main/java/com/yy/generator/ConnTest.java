package com.yy.generator;


import java.sql.*;

public class ConnTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.127.132:5432/tender_notice", "tender_notice", "wds123654");
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from pg_class;");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String string = resultSet.getString("relname");
                System.out.println(string);
            }
            long end = System.nanoTime();
        }
        connection.close();
    }
}
