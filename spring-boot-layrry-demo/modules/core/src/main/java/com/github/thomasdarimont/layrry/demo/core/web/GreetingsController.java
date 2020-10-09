package com.github.thomasdarimont.layrry.demo.core.web;

import com.github.thomasdarimont.layrry.demo.core.GreetingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GreetingsController {

    static {
        System.out.println("Loaded GreetingsController.class");
    }

    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/")
    Object greet(@RequestParam(defaultValue = "World") String name) {
        return Map.of("greeting", greetingsService.greet(name));
    }
}
