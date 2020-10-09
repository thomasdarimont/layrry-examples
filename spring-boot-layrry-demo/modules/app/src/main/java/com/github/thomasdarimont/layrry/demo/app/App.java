package com.github.thomasdarimont.layrry.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        Thread.currentThread().setContextClassLoader(App.class.getClassLoader());
        SpringApplication.run(App.class, args);
    }
}

@RestController
class InfoController {

    @GetMapping("/info")
    Object info() {
        return Map.of("time", Instant.now());
    }
}