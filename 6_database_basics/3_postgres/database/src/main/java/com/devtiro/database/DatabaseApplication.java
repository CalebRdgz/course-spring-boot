package com.devtiro.database;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
//easy access to logger:
@Log
public class DatabaseApplication implements CommandLineRunner {
	//injecting the DataSource object
	private final DataSource dataSource;

	public DatabaseApplication(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		//printing out the DataSource using log.info
		log.info("Datasource: " + dataSource.toString());
		//using restTemplate for an easy way to interact with the database:
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		//executing 'select 1' in the SQL query
		restTemplate.execute("select 1");
	}

}
