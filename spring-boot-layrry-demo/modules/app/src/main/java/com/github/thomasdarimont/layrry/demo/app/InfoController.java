package com.github.thomasdarimont.layrry.demo.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
class InfoController {

    @GetMapping("/info")
    Object info() {
        return Map.of("time", Instant.now());
    }
}
