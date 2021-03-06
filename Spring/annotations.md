

### @SpringBootApplication 
Spring needs to know which packages to scan for annotated components in order to add them to the IoC container.
The main application should be set with the **@SpringBootApplication**

Under the hood, **@SpringBootApplication** is a composition of the **@Configuration, @ComponentScan, and @EnableAutoConfiguration** annotations.

Is a convenience annotation that adds all of the following:

### @ComponentScan 
Tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.
**This is related to the package to scan.**

Enabling component scanning with scan(String...)
To enable component scanning, just annotate your @Configuration class as follows:
  @Configuration
  @ComponentScan(basePackages = "com.acme")
  public class AppConfig  {
... }


### @EnableAutoConfiguration 
Often placed on your main class. 
Implicitly defines a base “search package” for certain items. 
For example, if you are writing a JPA application, the package of the @EnableAutoConfiguration annotated class will be used to search for @Entity items.

Using a root package also allows the **@ComponentScan** annotation to be used without needing to specify a basePackage attribute. You can also use the **@SpringBootApplication** annotation if your main class is in the root package.

#### @RestController
Meaning it’s ready for use by Spring MVC to handle web requests. 
This is known as a stereotype annotation. It provides hints for people reading the code, and for Spring, that the class plays a specific role. In this case, our class is a web @Controller so Spring will consider it when handling incoming web requests.


[Tip]
The @RestController annotation is a Spring MVC annotations (they are not specific to Spring Boot). See the MVC section in the Spring Reference Documentation for more details.


#### @RequestMapping 
maps to the index() method. When invoked from a browser or using curl on the command line, the method returns pure text. That’s because @RestController combines @Controller and @ResponseBody, two annotations that results in web requests returning data rather than a view.

The @RequestMapping annotation provides “routing” information. It is telling Spring that any HTTP request with the path “/” should be mapped to the home method. The @RestController annotation tells Spring to render the resulting string directly back to the caller.

[Tip]
The @RequestMapping annotation is a Spring MVC annotations (they are not specific to Spring Boot). See the MVC section in the Spring Reference Documentation for more details.

----------------------

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

@RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. This query string parameter is explicitly marked as optional (required=true by default): if it is absent in the request, the defaultValue of "World" is used.

	public String getDetails(@RequestParam(value="param1", required=true) String param1,
		        	   @RequestParam(value="param2", required=false) String param2){
		...
	}

The following are the list of parameters supported by the **@RequestParam** annotation:

**defaultValue** – This is the default value as a fallback mechanism if request is not having the value or it is empty.

**name** – Name of the parameter to bind.

**required** – Whether the parameter is mandatory or not. If it is true, failing to send that parameter will fail.

**value** – This is an alias for the name attribute


URL:  

    http://localhost:8080/springmvc/hello/101?param1=10&param2=20
    
 
    @RequestMapping("/hello/{id}")    
    public String getDetails(@PathVariable(value="id") String id,
         @RequestParam(value="param1", required=true) String param1,
         @RequestParam(value="param2", required=false) String param2) {
         .......
     }
     

**@PathVariable** annotation has only one attribute value for binding the request URI template. 
It is allowed to use the multiple **@PathVariable** annotation in the single method. 
But, ensure that no more than one method has the same pattern.




#### MongoDB annotations

    package hello;

    import java.util.List;

    import org.springframework.data.mongodb.repository.MongoRepository;
    import org.springframework.data.repository.query.Param;
    import org.springframework.data.rest.core.annotation.RepositoryRestResource;

    @RepositoryRestResource(collectionResourceRel = "people", path = "people")
    public interface PersonRepository extends MongoRepository<Person, String> {

	    List<Person> findByLastName(@Param("name") String name);

    }


At runtime, Spring Data REST will create an implementation of this interface automatically. 
Then it will use the @RepositoryRestResource annotation to direct Spring MVC to create RESTful endpoints at **/people**.










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
But with **@Component, @Repository, @Service, @Controller** annotations in place and after enabling automatic component scanning, spring will automatically import the beans into the container so you don’t have to define them explicitly with XML. These annotations are called Stereotype annotations as well.

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
