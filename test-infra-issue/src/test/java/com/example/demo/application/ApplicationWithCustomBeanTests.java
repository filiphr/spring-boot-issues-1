package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.autoconfigure.MyCustomAutoConfiguration;
import com.example.demo.autoconfigure.MyCustomBean;

/**
 * @author Filip Hrisafov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationWithCustomBeanTests.CustomBeanTestConfiguration.class)
public class ApplicationWithCustomBeanTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        assertThat(applicationContext.getBean(MyCustomAutoConfiguration.NestedConfiguration.class)).isNotNull();
    }

    @TestConfiguration
    static class CustomBeanTestConfiguration {

        @Bean
        public MyCustomBean myCustomBean() {
            return new MyCustomBean();
        }
    }
}
