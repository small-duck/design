package com.zy.design.template;

import java.sql.ResultSet;

/**
 * @ClassName RowMapper
 * @Description
 * @Author Benny
 * @Date 2018/8/2 0002 9:47
 * @Version 1.0
 **/
public interface RowMapper<T> {

    public T mapRow(ResultSet rs, int row) throws Exception;


}
