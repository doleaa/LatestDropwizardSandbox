package doleaa.sandbox.rest;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import doleaa.sandbox.rest.resources.HelloWorldResource;
import doleaa.sandbox.rest.resources.MathsResource;

public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    @SneakyThrows
    public void run(Configuration c, Environment e) {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new HelloWorldResource());
        e.jersey().register(new MathsResource());
    }

    @SneakyThrows
    public static void main(String[] args) {
        new App().run(args);
    }
}
