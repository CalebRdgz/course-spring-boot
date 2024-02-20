package com.deviro.maven.services.impl;

import com.deviro.maven.services.RedPrinter;
import org.springframework.stereotype.Component;

 //this makes RedPrinter a Bean, so will fix 'could not be found' error
public class EnglishRedPrinter implements RedPrinter {

  @Override
  public String print() {
    return "red";
  }
}
