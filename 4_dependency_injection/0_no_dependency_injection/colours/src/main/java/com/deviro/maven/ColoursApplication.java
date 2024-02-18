package com.deviro.maven;

import com.deviro.maven.services.ColourPrinter;
import com.deviro.maven.services.impl.ColourPrinterImpl;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication annotation = this is our entry point
@SpringBootApplication
@Log
//CommandLineRunner = This is a Spring Boot Command Line Application
public class ColoursApplication implements CommandLineRunner {
    //declare a private instance variable on this class:
    private ColourPrinter colourPrinter;

    //create a constructor for that private instance variable^
    //the constructor takes in a colourprinter argument itself
    public  ColoursApplication(ColourPrinter colourPrinter) {
        //assigns the instance variable with the colourPrinter argument provided in the constructor:
        this.colourPrinter = colourPrinter;
    }

  public static void main(String[] args) {
    SpringApplication.run(ColoursApplication.class, args);
  }
// By implementing CommandLineRunner, we can override this run method:
  @Override
  public void run(final String... args) {
    //change our run method to use the colourPrinter as provided:
      log.info(colourPrinter.print());
  }
}
