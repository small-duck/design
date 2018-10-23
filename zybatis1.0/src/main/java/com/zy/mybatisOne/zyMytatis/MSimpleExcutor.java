package com.zy.mybatisOne.zyMytatis;

import java.sql.*;
import java.util.concurrent.Executor;

/**
 * @ClassName MSimpleExcutor
 * @Description
 * @Author Benny
 * @Date 2018/8/11 0011 23:01
 * @Version 1.0
 **/
public class MSimpleExcutor implements Mexcutor {
    @Override
    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User test = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tests?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");
            preparedStatement = connection.prepareStatement(String.format(statement, Integer.parseInt(parameter)));

//            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                test = new User();
                test.setAge(rs.getInt(1));
//                test.setAge(rs.getInt(2));
//                test.setSex(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T) test;
    }
}
