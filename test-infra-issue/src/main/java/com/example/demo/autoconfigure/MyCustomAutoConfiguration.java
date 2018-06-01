package com.example.demo.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Filip Hrisafov
 */
//@Configuration
@ConditionalOnClass({
    MyCustomBean.class
})
public class MyCustomAutoConfiguration {

    @Configuration
    @EnableConfigurationProperties(MyCustomProperties.class)
    @ConditionalOnBean({
        MyCustomBean.class
    })
    public class NestedConfiguration {

        protected final MyCustomProperties myCustomProperties;

        public NestedConfiguration(MyCustomProperties myCustomProperties) {
            this.myCustomProperties = myCustomProperties;
        }
    }
}
