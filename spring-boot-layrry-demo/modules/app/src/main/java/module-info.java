module com.github.thomasdarimont.layrry.demo.app {

    requires spring.context;
    requires spring.web;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires com.github.thomasdarimont.layrry.demo.core;

    exports com.github.thomasdarimont.layrry.demo.app;

    opens com.github.thomasdarimont.layrry.demo.app to spring.core, spring.context;
}