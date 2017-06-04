
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

The annotated class is a "Service"
This annotation is a general-purpose stereotype.
This annotation serves as a specialization of @Component.

#### @Component
----

Allowing for implementation classes to be autodetected through classpath scanning.
