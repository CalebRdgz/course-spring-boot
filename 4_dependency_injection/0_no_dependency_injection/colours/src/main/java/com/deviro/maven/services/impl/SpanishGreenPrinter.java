package com.deviro.maven.services.impl;

import com.deviro.maven.services.GreenPrinter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service //Descriptive of what this class does.
//Service layer - we use services, so label this bean as a service bean
public class SpanishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "verde";
    }
}
