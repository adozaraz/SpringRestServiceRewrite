package ru.aston.springservice.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"ru.aston.springservice.repositories"})
@ComponentScan(basePackages = {"ru.aston.springservice.repositories"})
@PropertySource("classpath:application.properties")
public class PersistenceContext {
    private final Environment environment;

    @Autowired
    public PersistenceContext(Environment environment) {
        this.environment = environment;
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSourceConfig = new DriverManagerDataSource ();
        dataSourceConfig.setDriverClassName(environment.getRequiredProperty("db.driver"));
        dataSourceConfig.setUrl(environment.getRequiredProperty("db.url"));
        dataSourceConfig.setUsername(environment.getRequiredProperty("db.username"));
        dataSourceConfig.setPassword(environment.getRequiredProperty("db.password"));

        return dataSourceConfig;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("ru.aston.springservice");
        entityManagerFactory.setJpaProperties(getProperties());
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactory;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }
}
