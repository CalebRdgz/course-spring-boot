package com.devtiro.database;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner {
	//injecting a DataSource object that interacts with the Database:
	private final DataSource dataSource;
	//the constructor that does the injection:
	public DatabaseApplication(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	//run method (using CommandLineRunner)
	public void run(final String... args) {
		//printing our the dataSource to the command line logger (log.info() from @Log Lombok annotation)
		log.info("Datasource: " + dataSource.toString());
		//creating an instance of the Jdbc template, using this to query the database:
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		//querying the database with "select 1" (lets us know we're connected to the database and query it):
		restTemplate.execute("select 1");
	}

}

