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

        // Bootstrap module layer

//        // 1. Detect OS
//        String osName = System.getProperty("os.name").toLowerCase();
//
//        // 2. Map OS to JavaFX classifier
//        String classifier = "";
//        if (osName.contains("windows")) {
//            classifier = "win";
//        } else if (osName.contains("mac")) {
//            classifier = "mac";
//        } else if (osName.contains("linux")) {
//            classifier = "linux";
//        } else {
//            throw new IllegalStateException("JavaFX is not supported on " + System.getProperty("os.name"));
//        }

        // 3. Load module versions
        Properties props = new Properties();
        props.load(Launcher.class.getClassLoader().getResourceAsStream("META-INF/versions.properties"));
//        props.put("classifier", classifier);

        // 4. Load config template
        StringWriter layerConfig = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("META-INF/layers.toml");
        mustache.execute(layerConfig, props);

        // 5. Create layers from config
        Path rootDir = Paths.get(".").toAbsolutePath();
        if (args != null && args.length > 0) {
            rootDir = Paths.get(args[0]).toAbsolutePath();
        }
        LayersConfig config = new TomlLayersConfigParser().parse(new ByteArrayInputStream(layerConfig.toString().getBytes()));
        Layers layers = new LayersFactory().createLayers(config, rootDir);

        // 6. Launch application
        layers.run(config.getMain().getModule() + "/" + config.getMain().getClazz(), args);
    }
}
