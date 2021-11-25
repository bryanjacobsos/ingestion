package com.os.uop.ingestion.rapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The below main method starts the rest api.
 *
 * @see com.os.uop.ingestion.rapi.rest.ExportLogsServiceRequestRest to see how the code flow works
 */
@SpringBootApplication
public class App {

    /**
     * Starts the REST API listening on the configured port in the application.properties or
     * overridden on the commandline
     *
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }

}
