package com.himalaya.config;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class WeatherAppDispatcherServletInitializerTest {

    @Test
    void shouldSetServletMappingsAndConfigClasses() {
        WeatherAppDispatcherServletInitializer initializer =
                new WeatherAppDispatcherServletInitializer();

        String[] mappings = new String[]{"/"};
        Assertions.assertArrayEquals(mappings, initializer.getServletMappings());
        assertThat(mappings[0], CoreMatchers.is(equalTo("/")));
    }
}