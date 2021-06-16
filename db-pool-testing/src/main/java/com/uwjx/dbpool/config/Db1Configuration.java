package com.uwjx.dbpool.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@Slf4j
@MapperScan(basePackages = "com.uwjx.dbpool.mapper_db1", sqlSessionFactoryRef = "db1SqlSessionFactory")
public class Db1Configuration {

    @Value("${spring.datasource.db1.url}")
    private String url;
    @Value("${spring.datasource.db1.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.db1.username}")
    private String username;
    @Value("${spring.datasource.db1.password}")
    private String password;
    @Value("${spring.datasource.db1.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.db1.maximum-pool-size}")
    private int maximumPoolSize;

    @Bean(name = "db1DataSource")
    @Primary
    public DataSource getDateSource1() {
        return hikariDataSource();
    }

    public HikariDataSource hikariDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMinimumIdle(minIdle);
        dataSource.setMaximumPoolSize(maximumPoolSize);
        return dataSource;
    }

    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper_db1/*.xml"));
        return bean.getObject();
    }

    @Bean("db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate db1SqlSessionTemplate(
            @Qualifier("db1SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
