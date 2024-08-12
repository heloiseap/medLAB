package com.medLAB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedLabApplication {
    private static final Logger LOGGER = LogManager.getLogger(MedLabApplication.class);


	public static void main(String[] args) {

        SpringApplication.run(MedLabApplication.class, args);
        LOGGER.debug("nivel debug");
        LOGGER.info("nivel INFO");
        LOGGER.warn("nivel WARN");

    }
}
