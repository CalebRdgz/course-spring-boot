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

  public static void main(String[] args) {
    SpringApplication.run(ColoursApplication.class, args);
  }
// By implementing CommandLineRunner, we can override this run method:
  @Override
  public void run(final String... args) {
      //this run method creates an instance of ColourPrinter using the java new keyword:
    final ColourPrinter colourPrinter = new ColourPrinterImpl();
    //then prints out the colors given back by colourPrinter.print() to the command line:
    log.info(colourPrinter.print());
  }
}
