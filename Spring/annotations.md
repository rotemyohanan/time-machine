
#### Spring default bean scope:
----

Spring produces a new bean instance each time one is needed. 
Decleration of the bean's scope attribute to be prototype. 


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

#### @Component
----
The @Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application contex.

    @Component
    public class EmployeeDAOImpl implements EmployeeDAO {
        ...
    }
    
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

### Stereotype annotations
----
Define the beans themselves so the container is aware of them and can inject them for you. 
But with @Component, @Repository, @Service and @Controller annotations in place and after enabling automatic component scanning, spring will automatically import the beans into the container so you don’t have to define them explicitly with XML. These annotations are called Stereotype annotations as well.


### How to enable component scanning
--

To enable scanning, you will need to use **“context:component-scan”** tag in your **applicationContext.xml** file. e.g.

    <context:component-scan base-package="com.howtodoinjava.demo.service" />
    <context:component-scan base-package="com.howtodoinjava.demo.dao" />
    <context:component-scan base-package="com.howtodoinjava.demo.controller" />

The context:component-scan element requires a base-package attribute, which, as its name suggests, specifies a starting point for a recursive component search. 
