package com.rpramadhan.sbspringdata.main;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author rpramadhan
 * Enter point for Liquibase Application
 */
@SpringBootApplication
@ComponentScan("com.rpramadhan.sbspringdata")
@EntityScan({"com.rpramadhan.sbspringdata.model"})
@EnableJpaRepositories({"com.rpramadhan.sbspringdata.repository"})
public class SBSpringDataMain {
	
	@Autowired
	private DataSource dataSource;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SBSpringDataMain.class, args);
	}
	
	@Bean
	public SpringLiquibase liquibase() {
	    SpringLiquibase liquibase = new SpringLiquibase();
	    liquibase.setChangeLog("classpath:liquibase/liquibase.xml");
	    liquibase.setDataSource(dataSource);
	    return liquibase;
	}

}
