package com.customerService.intsv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.customerService.intsv")
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("com.customerService.intsv.repository")
@PropertySource("classpath:application.properties")
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Value("${spring.datasource.url}")
    private String databaseURL;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${spring.datasource.username}")
    private String datasourceUsername;
    @Value("${spring.datasource.password}")
    private String datasourcePassword;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;
    @Value("${spring.jpa.show-sql}")
    private boolean showSQL;

    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(databaseURL);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);

        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("spring.jpa.properties.hibernate.dialect", hibernateDialect);
        properties.put("spring.jpa.show-sql", showSQL);

        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.spring_data_new");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }
}
