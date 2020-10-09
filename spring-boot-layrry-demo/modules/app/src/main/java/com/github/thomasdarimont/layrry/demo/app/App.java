package com.github.thomasdarimont.layrry.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@SpringBootApplication
// scan modules package for components
@ComponentScan(basePackages = "com.github.thomasdarimont.layrry.demo.modules")
public class App {

    public static void main(String[] args) {

        // ensure spring uses the module-classloader
        Thread.currentThread().setContextClassLoader(App.class.getClassLoader());

        SpringApplication.run(App.class, args);
    }
}