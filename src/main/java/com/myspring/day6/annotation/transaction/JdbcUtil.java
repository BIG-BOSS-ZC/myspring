package com.myspring.day6.annotation.transaction;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
@Aspect
public class JdbcUtil {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static String userName = "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    static Connection connection;
    static Statement statement;

    static {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,userName,password);
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Pointcut("execution(* com..day6.annotation.transaction.AccountService.*(..))")
    public void pc2(){}

    @Before("pc2()")
    public void transaction_begin() throws SQLException {
        System.out.println("begin");
        connection.setAutoCommit(false);
    }

    @AfterReturning("pc2()")
    public void transaction_commit() throws SQLException {
        System.out.println("commit");
        connection.commit();
    }

    @AfterThrowing("pc2()")
    public void transaction_rollback() throws SQLException {
        System.out.println("rollback");
        connection.rollback();
    }

    @After("pc2()")
    public void transaction_release() throws SQLException {
        System.out.println("release");
    }
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement statement = connection.prepareStatement("select * from account");
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("username") +
                        "\t" + resultSet.getString("password") + "\t" + resultSet.getDouble("money") +
                        "\t" + resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
