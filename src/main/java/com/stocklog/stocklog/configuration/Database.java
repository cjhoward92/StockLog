package com.stocklog.stocklog.configuration;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Log4j2
@Configuration
@MapperScan("com.stocklog.stocklog.data")
public class Database {

    @Bean
    public SqlSessionFactory getSqlSessionFactory(final DataSource dataSource) throws Exception {
        log.info("Building sql session factory");

        var bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.stocklog.stocklog.data");

        return bean.getObject();
    }
}
