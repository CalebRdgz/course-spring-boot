package com.deviro.maven.services.impl;

import com.deviro.maven.services.BluePrinter;
import com.deviro.maven.services.ColourPrinter;
import com.deviro.maven.services.GreenPrinter;
import com.deviro.maven.services.RedPrinter;

public class ColourPrinterImpl implements ColourPrinter {
    //these are three dependencies for this ColourPrinterImpl:
    //each of these classes has a single method 'String print()'
  private RedPrinter redPrinter;
  private BluePrinter bluePrinter;
  private GreenPrinter greenPrinter;

  public ColourPrinterImpl() {
      //inside of this ColourPrinterImpl constructor, were creating new redprinter, blueprinter, greenprinter
      // (english being the language its printing 'red' into the command line in)
      //we DO NOT want to do it this way (creating a new red printer in the constructor):
    this.redPrinter = new EnglishRedPrinter();
    this.bluePrinter = new EnglishBluePrinter();
    this.greenPrinter = new EnglishGreenPrinter();
  }
//using these three dependencies above^, we're implementing the print method to print out: "red, blue, green"
  @Override
  public String print() {
    return String.join(", ", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
  }
}
