package com.example.config1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Filip Hrisafov
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class RestConfig1 {

    /**
     * @author Filip Hrisafov
     */
    @RestController
    public static class Controller1 {

        @GetMapping
        public String test1() {
            return "test1";
        }
    }
}
