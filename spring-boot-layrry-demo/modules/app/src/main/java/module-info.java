module com.github.thomasdarimont.layrry.demo.app {

    requires spring.context;
    requires spring.web;

    requires spring.boot;
    requires spring.boot.autoconfigure;
//    requires com.github.thomasdarimont.layrry.demo.core;

    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    exports com.github.thomasdarimont.layrry.demo.app;

    opens com.github.thomasdarimont.layrry.demo.app to spring.core, spring.context;
}