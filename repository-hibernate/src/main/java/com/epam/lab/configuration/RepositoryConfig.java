package com.epam.lab.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement(proxyTargetClass = true)
public class RepositoryConfig {

    private static final String URL = "url";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String DRIVER_CLASS_NAME = "driverClassName";

    private static final String PACKAGE_TO_SCAN = "com.epam.lab";

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(Environment environment) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getHikariDS(environment));
        entityManagerFactoryBean.setPackagesToScan(PACKAGE_TO_SCAN);
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

    @Bean
    public HikariDataSource getHikariDS(Environment environment) {
        return new HikariDataSource(getHikariConfig(environment));
    }

    @Bean
    public HikariConfig getHikariConfig(Environment environment) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(environment.getProperty(DRIVER_CLASS_NAME));
        config.setJdbcUrl(environment.getProperty(URL));
        config.setUsername(environment.getProperty(NAME));
        config.setPassword(environment.getProperty(PASSWORD));
        return config;
    }

}
