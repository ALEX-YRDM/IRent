package com.xdu.irent;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


@SpringBootApplication
@MapperScan("com.xdu.irent.dao")
@EnableCaching
public class IRentApplication {
    @Autowired
    DataSource dataSource;
    public static void main(String[] args) {
        SpringApplication.run(IRentApplication.class, args);
    }


}
