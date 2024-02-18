package com.deviro.maven.config;

import com.deviro.maven.services.BluePrinter;
import com.deviro.maven.services.ColourPrinter;
import com.deviro.maven.services.GreenPrinter;
import com.deviro.maven.services.RedPrinter;
import com.deviro.maven.services.impl.ColourPrinterImpl;
import com.deviro.maven.services.impl.EnglishBluePrinter;
import com.deviro.maven.services.impl.EnglishGreenPrinter;
import com.deviro.maven.services.impl.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//@Configuration = tells Spring to look in this class for Bean declarations:
@Configuration
public class PrinterConfig {
    //create a method that is going to be our Bean declaration:
    @Bean
    //returns the type 'BluePrinter'
    public BluePrinter bluePrinter() {
        //The implementation of this method is going to return the implementation of BluePrinter
        //return a new instance of EnglishBluePrinter:
        return new EnglishBluePrinter();
    }
    //do the same for the other printers as well:
    @Bean
    public RedPrinter redPrinter() {
        return new EnglishRedPrinter();
    }

    @Bean
    public GreenPrinter greenPrinter() {
        return new EnglishGreenPrinter();
    }
    //When we start the app, Spring will look for config files, then find this printer config
    //then it will create the beans for bluePrinter, redPrinter, and greenPrinter
    //then when it gets to colourPrinter, it looks in the app context for bluePrinter, redPrinter, and greenPrinter,
    //then inject them into this bean declaration and in our app context, we have this ColourPrinter bean:
    //which is injected into the ColoursApplication class

    @Bean
    public ColourPrinter colourPrinter(BluePrinter bluePrinter, RedPrinter redPrinter, GreenPrinter greenPrinter) {
        //going to require some dependencies, declare them as arguments inside colourPrinter bean declaration^
        return new ColourPrinterImpl(redPrinter, bluePrinter, greenPrinter);
    }
}
