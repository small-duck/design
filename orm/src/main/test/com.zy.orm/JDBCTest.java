package com.zy.orm;

import com.sun.org.apache.regexp.internal.RE;
import com.zy.orm.domain.User;
import javafx.scene.control.Tab;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName JDBCTest
 * @Description
 * @Author Benny
 * @Date 2018/8/28 0028 10:53
 * @Version 1.0
 **/
@Entity
@Table(name = "user")
public class JDBCTest {
    public static void main(String[] args) {
        List<?> select = select(new User());
        System.err.println(Arrays.toString(select.toArray()));

    }

    private static List<?> select(Object condition) {
        try {


            Class<?> entityClass = condition.getClass();
            //1 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2 创建链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tests","root","123456");
            Table table = entityClass.getAnnotation(Table.class);
            //3 创建语句集 开始事务
            String sql = "select * from "+table.name();

            // 4 执行语句集
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            //5 获取结果集
            // 表中的记录要赋值到java 的Objective中
            // 反射机制  自动赋值
            List<Object> result = new ArrayList<>();
            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Object instan = entityClass.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName= rs.getMetaData().getColumnName(i);
                    Field field = entityClass.getDeclaredField(columnName);
                    field.setAccessible(true);
                    // 数据类型映射非常关键
                    Class<?> type = field.getType();
                    if (type == Integer.class) {
                        field.set(instan, rs.getInt(columnName));
                    } else if (String.class == type) {
                        field.set(instan, rs.getString(columnName));
                    }

                    field.set(instan,rs.getObject(columnName));
                }

                result.add(instan);
            }


            // 6 关闭结果集 语句集
//            System.err.println(Arrays.toString(result.toArray()));

            rs.close();
            statement.close();
            connection.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
