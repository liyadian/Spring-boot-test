package com.lyd.springboot.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
/*

@Configuration
public class DataSourceConfig {

    @Bean(name="datasource")
    public DataSource datasource(Environment env){
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        return ds;
    }
}

 */
