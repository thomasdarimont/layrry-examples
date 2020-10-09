Modular Spring Boot Appy with Layyry 
---

WIP

This is dereived from the [modular-tiles](https://github.com/moditect/layrry-examples/tree/master/modular-tiles) example
by @aalmiray.

# Build
```
mvn clean install
```

# Run

Run the `com.github.thomasdarimont.layrry.demo.Launcher` class from the `launcher` module.

# ToDo's

- [] Rename project to modular-spring-boot-example
- [] Revise packaging
- [] Update run section
- [] Revise layers.toml -> introduce platform-layer (for spring dependencies)
- [] Try to generate layers.toml from maven pom
- [] Add a service with SPI that can be loaded via ServiceLoader 
- [] Add another example module