package com.github.thomasdarimont.layrry.demo.core;

import org.springframework.stereotype.Service;

@Service
public class DefaultGreetingsService implements GreetingsService {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
}
