package com.github.thomasdarimont.layrry.demo;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.moditect.layrry.Layers;
import org.moditect.layrry.config.LayersConfig;
import org.moditect.layrry.config.toml.TomlLayersConfigParser;
import org.moditect.layrry.internal.LayersFactory;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Launcher {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.load(Launcher.class.getClassLoader().getResourceAsStream("META-INF/versions.properties"));

        StringWriter layerConfig = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("META-INF/layers.toml");
        mustache.execute(layerConfig, props);

        Path rootDir = Paths.get(".").toAbsolutePath();
        if (args != null && args.length > 0) {
            rootDir = Paths.get(args[0]).toAbsolutePath();
        }
        LayersConfig config = new TomlLayersConfigParser().parse(new ByteArrayInputStream(layerConfig.toString().getBytes()));
        Layers layers = new LayersFactory().createLayers(config, rootDir);

        layers.run(config.getMain().getModule() + "/" + config.getMain().getClazz(), args);
    }
}
