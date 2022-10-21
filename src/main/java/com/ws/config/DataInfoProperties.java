package com.ws.config;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Data;
import lombok.Getter;

//@ConfigMapping(prefix = "data")
@Data
@ConfigProperties(prefix = "data")
public class DataInfoProperties {

    private String name;
    private String lastname;
    private Long age;
    private String country;

}
