package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("get code: {}", this.code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("set code: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("get name: {}", this.name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("set name: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
