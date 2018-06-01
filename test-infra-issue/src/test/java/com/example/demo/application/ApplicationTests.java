package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.autoconfigure.MyCustomAutoConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {

        assertThatThrownBy(() -> applicationContext.getBean(MyCustomAutoConfiguration.NestedConfiguration.class))
            .isInstanceOf(NoSuchBeanDefinitionException.class);
    }
}
