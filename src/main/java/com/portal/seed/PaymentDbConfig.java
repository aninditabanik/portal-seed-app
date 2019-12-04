package com.portal.seed;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "paymentEntityManagerFactory",
        transactionManagerRef = "paymentTransactionManager",
        basePackages = { "com.portal.seed.payment.repo" }
)
public class PaymentDbConfig {

    @Bean(name = "paymentDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "paymentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    paymentEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("paymentDataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.portal.seed.payment.model")
                        .persistenceUnit("payments")
                        .build();
    }
    @Bean(name = "paymentTransactionManager")
    public PlatformTransactionManager paymentTransactionManager(
            @Qualifier("paymentEntityManagerFactory") EntityManagerFactory
                    paymentEntityManagerFactory
    ) {
        return new JpaTransactionManager(paymentEntityManagerFactory);
    }
}