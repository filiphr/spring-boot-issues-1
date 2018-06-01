package com.example.demo.autoconfigure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Filip Hrisafov
 */
public class MyCustomAutoConfigurationTest {

    private ApplicationContextRunner contextRunner = new ApplicationContextRunner()
        .withConfiguration(AutoConfigurations.of(
            MyCustomAutoConfiguration.class
        ));

    @Test
    public void withCustomBeanMissing() {
        contextRunner.run(context -> assertThat(context)
            .doesNotHaveBean(MyCustomAutoConfiguration.NestedConfiguration.class)
            .doesNotHaveBean(MyCustomProperties.class));
    }

    @Test
    public void withCustomBeanPresent() {
        contextRunner
            .withUserConfiguration(TestUserConfiguration.class)
            .run(context -> assertThat(context)
                .hasSingleBean(MyCustomAutoConfiguration.NestedConfiguration.class)
                .hasSingleBean(MyCustomProperties.class));
    }

    @Configuration
    static class TestUserConfiguration {

        @Bean
        public MyCustomBean myCustomBean() {
            return new MyCustomBean();
        }
    }
}
