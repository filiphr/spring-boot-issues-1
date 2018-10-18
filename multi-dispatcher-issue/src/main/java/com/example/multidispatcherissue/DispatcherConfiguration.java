package com.example.multidispatcherissue;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.config1.RestConfig1;

/**
 * @author Filip Hrisafov
 */
@Configuration
public class DispatcherConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    private MultipartConfigElement multipartConfigElement;

    @Bean
    public ServletRegistrationBean service1() {
        AnnotationConfigWebApplicationContext dispatcherServletConfiguration = new AnnotationConfigWebApplicationContext();
        dispatcherServletConfiguration.setParent(applicationContext);
        dispatcherServletConfiguration.register(RestConfig1.class);
        DispatcherServlet servlet = new DispatcherServlet(dispatcherServletConfiguration);
        ServletRegistrationBean<DispatcherServlet> registrationBean = new ServletRegistrationBean<>(servlet, "/service1");
        registrationBean.setName("TestServlet service1");
        registrationBean.setLoadOnStartup(-1);
        registrationBean.setAsyncSupported(true);

        if (multipartConfigElement != null) {
            registrationBean.setMultipartConfig(multipartConfigElement);
        }
        return registrationBean;
    }

    @Autowired(required = false)
    public void setMultipartConfigElement(MultipartConfigElement multipartConfigElement) {
        this.multipartConfigElement = multipartConfigElement;
    }

}
