package com.zy.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @ClassName DataSourceConfig
 * @Description 数据源配置类
 * @Author Benny
 * @Date 2018/8/12 0012 17:08
 * @Version 1.0
 **/
@Configuration
@ComponentScan(basePackages = "com.zy.mybatis")
@PropertySource("classpath:db.properties")
public class DataSourceConfig {

    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.uid}")
    private String username;

    @Value("${jdbc.pwd}")
    private String pwd;

    @Bean(name = "dataSource",initMethod = "init", destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(pwd);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setConnectionProperties("config.decrypt=true");
//        dataSource.setFilters("stat,config");
        dataSource.setMaxActive(20);
        dataSource.setInitialSize(20);
        dataSource.setMaxWait(60000);
        dataSource.setMinIdle(1);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(false);
        dataSource.setMaxOpenPreparedStatements(20);
        dataSource.setConnectionErrorRetryAttempts(5);
        return dataSource;
    }
//
    @Bean
    public static PropertySourcesPlaceholderConfigurer loadProperties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }
}
