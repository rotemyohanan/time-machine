

### @SpringBootApplication 
Is a convenience annotation that adds all of the following:

### @ComponentScan 
Tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.


### @EnableAutoConfiguration 
Often placed on your main class. 
Implicitly defines a base “search package” for certain items. 
For example, if you are writing a JPA application, the package of the @EnableAutoConfiguration annotated class will be used to search for @Entity items.

Using a root package also allows the **@ComponentScan** annotation to be used without needing to specify a basePackage attribute. You can also use the **@SpringBootApplication** annotation if your main class is in the root package.

#### @RestController
Meaning it’s ready for use by Spring MVC to handle web requests. 


#### @RequestMapping 
maps to the index() method. When invoked from a browser or using curl on the command line, the method returns pure text. That’s because @RestController combines @Controller and @ResponseBody, two annotations that results in web requests returning data rather than a view.


#### Bean

    @Bean // Is used to define a custom bean.

#### PostConstruct

@PostConstruct

#### Spring default bean scope:
----

Spring produces a new bean instance each time one is needed. 
Decleration of the bean's scope attribute to be prototype. 

### Stereotype annotations
----
Define the beans themselves so the container is aware of them and can inject them for you. 
But with @Component, @Repository, @Service and @Controller annotations in place and after enabling automatic component scanning, spring will automatically import the beans into the container so you don’t have to define them explicitly with XML. These annotations are called Stereotype annotations as well.

Main Stereotype Spring annotations:

    @Component 
    @Service  (extends @Component) // holds the business logic layer
    @Repository  (extends @Component) // holds the data layer




#### @Component
----
The @Component annotation marks a java class as a bean so the **component-scanning mechanism** so spring can pick it up and pull it into the **application contex**.

  > Such classes are considered as candidates for auto-detection.
  > When using annotation-based configuration and classpath scanning.

Using Spring the component package path:
 
     package org.springframework.stereotype
     @interface
     @Component
     public class EmployeeDAOImpl implements EmployeeDAO {
         ...
     }

In the application the **@component** defines the class as a **Bean**.

    @Repository("customerRepository")  // the customerRepository is the @Repository's name
    @Service("customerService")        // the customerService is the @Service's name
    @Aspect ("org.aspectj.lang.annotation.Aspect")

#### @Singleton (default bean's scope)
----

If you want Spring to return the same bean instance each time one is needed, 
you should declare the bean's scope attribute to be **singleton**.
This scopes the bean definition to a single instance per Spring IoC container.

example:

    <?xml version = "1.0" encoding = "UTF-8"?> 
    <beans xmlns = "http://www.springframework.org/schema/beans" 
        xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation = "http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
        
        <bean id = "helloWorld" class = "com.tutorialspoint.HelloWorld" scope = "singleton">
        </bean>
    </beans>
        
##### @Service
----
The @Service annotation is also a specialization of the component annotation. 
It doesn’t currently provide any additional behavior over the @Component annotation, but it’s a good idea to use @Service over @Component in service-layer classes because it specifies intent better. 
Additionally, tool support and additional behavior might rely on it in the future.


#### @Repository annotation
----
It is a specialization of the @Component annotation.
In addition to importing the DAOs into the DI container, it also makes the unchecked exceptions (thrown from DAO methods) eligible for translation into Spring DataAccessException.


#### @Controller annotation 
----
Marks a class as a Spring Web MVC controller. 
ou can use another annotation i.e. **@RequestMapping** (to map URLs to instance methods of a class).


#### @Autowired
----
It handles only wiring of the bean to the specific class. 

### How to enable component scanning
-------

To enable scanning, you will need to use **“context:component-scan”** tag in your **applicationContext.xml** file. e.g.

    <context:annotation-config/>
    <context:component-scan base-package="com.howtodoinjava.demo.service" />
    <context:component-scan base-package="com.howtodoinjava.demo.dao" />
    <context:component-scan base-package="com.howtodoinjava.demo.controller" />

The context:component-scan element requires a base-package attribute, which, as its name suggests, specifies a starting point for a recursive component search. 


Emphasises:
 > Always use these **annotations over concrete classes**; not over interfaces.
 
 
### Configuration

    @ConfigurationProperties     // Turns all of your application configuration into typesafe POJOs

Tags the class as a source of bean definitions for the application context.

    @Component 

add the configuration in the component scan @EnableconfigurationProperties(MyConfig.class)


    @Inject
    private MyConfig config;

Validate the code using annotations:

    @NotNull
    @Patten   //regexp
    @Max
    @Min
    @Digit

configure third party classes
 


#### EnableAutoConfiguration

    @EnableAutoConfiguration

    @Import(EnableAutoConfigurationImportSelector.class)
    
Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
Normally you would add **@EnableWebMvc** for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.

SpringFactoriesLoader.loadFactoryNames(...)

/META-INF/spring.factories    // this is a properties file


### @Transactional

 > It is not working on private methods unless using AspectJs mode.
