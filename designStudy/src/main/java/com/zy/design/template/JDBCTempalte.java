package com.zy.design.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JDBCTempalte
 * @Description 仿写jdbc模板
 * @Author Benny
 * @Date 2018/8/2 0002 9:45
 * @Version 1.0
 **/
public class JDBCTempalte {

    private DataSource dataSource;

    public JDBCTempalte(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }

    private List<?> parseResultSet(ResultSet set,RowMapper rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int row = 1;
        while (set.next()) {
            result.add(rowMapper.mapRow(set, row++));
        }
        return result;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rw, Object[] values) {
        try {
            //1获取连接
            Connection connection = getConnection();
            //2:创建语句集
            PreparedStatement statement = connection.prepareStatement(sql);
            //3:执行语句集，并获取结果集
            ResultSet resultSet = statement.executeQuery();
            //4：解析结果集

            //5：关闭语句集
            resultSet.close();
            //6；关闭结果集
            statement.close();
            //关闭连接
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
