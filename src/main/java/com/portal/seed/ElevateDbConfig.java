package com.portal.seed;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "elevateEntityManagerFactory",
        transactionManagerRef = "elevateTransactionManager",
        basePackages = { "com.portal.seed.elevate.repo" }
)
public class ElevateDbConfig {

    @Bean(name = "elevateDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.third")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "elevateEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    elevateEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("elevateDataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.portal.seed.elevate.model")
                        .persistenceUnit("elevate")
                        .build();
    }
    @Bean(name = "elevateTransactionManager")
    public PlatformTransactionManager elevateTransactionManager(
            @Qualifier("elevateEntityManagerFactory") EntityManagerFactory
                    elevateEntityManagerFactory
    ) {
        return new JpaTransactionManager(elevateEntityManagerFactory);
    }
}