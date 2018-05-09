# Spring Boot Test infrastructure issue reproducal

When an auto configuration class such as [`MyCustomAutoConfiguration`](src/main/java/com/example/demo/autoconfigure/MyCustomAutoConfiguration.java)
with a nested configuration class with `@EnableConfigurationProperties` is missing a `@Configuration` (the root class) then the Spring Boot application 
works correctly. 
Run [`ApplicationTests`](src/test/java/com/example/demo/application/ApplicationTests.java) and
[`ApplicationWithCustomBeanTests`](src/test/java/com/example/demo/application/ApplicationWithCustomBeanTests.java).
However, when using the `ApplicationContextRunner` the stuff don't work in the same way.
Run [`MyCustomAutoConfigurationTest`](src/test/java/com/example/demo/autoconfigure/MyCustomAutoConfigurationTest.java).

If you add the missing `@Configuration` in `MyCustomAutoConfiguration` then the tests pass.
 