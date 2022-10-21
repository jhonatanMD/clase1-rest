package com.ws;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@QuarkusMain
public class ApplicationInitQuarkus {

    public static void main(String[] args) {
        log.info("LEVANTO PROYECTO QUARKUS");
        Quarkus.run(args);
    }
}
