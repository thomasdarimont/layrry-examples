package com.github.thomasdarimont.layrry.demo.modules.core;

import org.springframework.stereotype.Service;

@Service
public class DefaultGreetingsService implements GreetingsService {

    @Override
    public String greet(String name) {
        return "Greetings from " + getClass().getModule().getName() + " " + name;
    }
}
