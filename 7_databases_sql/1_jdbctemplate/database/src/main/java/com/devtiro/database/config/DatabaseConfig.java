package com.devtiro.database.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
//Configuration annotation
@Configuration //tells Spring to look in this class for Bean declarations
public class DatabaseConfig {

    @Bean //this bean is now used for querying in our database
    //create a JdbcTemplate Bean that takes in datasource as an argument:
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        //return a new instance of the JdbTemplate, passing in dataSource to connect to our database
        return new JdbcTemplate(dataSource);
    }

}
