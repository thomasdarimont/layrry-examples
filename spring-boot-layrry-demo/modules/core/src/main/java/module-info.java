module com.github.thomasdarimont.layrry.demo.modules.core {

    requires spring.context;
    requires spring.web;

    exports com.github.thomasdarimont.layrry.demo.modules.core;
    exports com.github.thomasdarimont.layrry.demo.modules.core.web;

    opens com.github.thomasdarimont.layrry.demo.modules.core to spring.core, com.github.thomasdarimont.layrry.demo.app;
    opens com.github.thomasdarimont.layrry.demo.modules.core.web to spring.core, com.github.thomasdarimont.layrry.demo.app;
}