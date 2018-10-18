### Problem with async loading of servlets

* Build the project with `./mvnw clean install -DskipTests`
* Run the application with `java -jar target/multi-dispatcher-issue-0.0.1-SNAPSHOT.jar`
* Do HTTP GET `http://localhost:8080/actuator/mappings`
* Stop the application. The closing of the context should take 2 seconds each.

Example:

```
2018-10-18 23:22:42.423  INFO 71237 --- [       Thread-5] ConfigServletWebServerApplicationContext : Closing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@63e31ee: startup date [Thu Oct 18 23:22:28 CEST 2018]; root of context hierarchy
2018-10-18 23:22:42.428  INFO 71237 --- [       Thread-5] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
2018-10-18 23:22:44.695  INFO 71237 --- [ost-startStop-2] .s.AnnotationConfigWebApplicationContext : Closing WebApplicationContext for namespace 'TestServlet service1-servlet': startup date [Thu Oct 18 23:22:39 CEST 2018]; parent: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@63e31ee
```

If you first do `http://localhost:8080/service1` and then `http://localhost:8080/actuator/mappings`
the closing of the context will be immediate.

Example:

```
2018-10-18 23:21:46.439  INFO 71167 --- [       Thread-5] ConfigServletWebServerApplicationContext : Closing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@16b4a017: startup date [Thu Oct 18 23:21:28 CEST 2018]; root of context hierarchy
2018-10-18 23:21:46.443  INFO 71167 --- [       Thread-5] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
2018-10-18 23:21:46.566  INFO 71167 --- [ost-startStop-2] .s.AnnotationConfigWebApplicationContext : Closing WebApplicationContext for namespace 'TestServlet service1-servlet': startup date [Thu Oct 18 23:21:39 CEST 2018]; parent: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@16b4a017
```

The same can be seen by running the `MultiDispatcherIssueApplicationTests` as well.

With 2.1.0.RC1 https://github.com/spring-projects/spring-boot/issues/13186 no longer works which means the servlets are not initialized
