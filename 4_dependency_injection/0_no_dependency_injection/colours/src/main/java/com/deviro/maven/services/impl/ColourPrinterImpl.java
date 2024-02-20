package com.deviro.maven.services.impl;

import com.deviro.maven.services.BluePrinter;
import com.deviro.maven.services.ColourPrinter;
import com.deviro.maven.services.GreenPrinter;
import com.deviro.maven.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component //Tells Spring that ColourPrinterImpl is a Bean and should be put inside the Application Context
//Also says that any dependencies required in my constructor should be injected aswell (redPrinter, bluePrinter, greenPrinter)
public class ColourPrinterImpl implements ColourPrinter {
    //these are three dependencies for this ColourPrinterImpl:
    //each of these classes has a single method 'String print()'
  private RedPrinter redPrinter;
  private BluePrinter bluePrinter;
  private GreenPrinter greenPrinter;
    //declare the beans inside of the constructor:
    // because Spring is going to use this constructor as a way of identify which dependencies are needed and inject them
  public ColourPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
    this.redPrinter = redPrinter;
    this.bluePrinter = bluePrinter;
    this.greenPrinter = greenPrinter;
  }
//using these three dependencies above^, we're implementing the print method to print out: "red, blue, green"
  @Override
  public String print() {
    return String.join(", ", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
  }
}
