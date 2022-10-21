package com.ws.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "data")
public interface DataProperties {

    String name();
    String lastname();
    Long age();

    String country();
}
