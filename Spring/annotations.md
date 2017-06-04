
#### Spring default bean scope:
----

Spring produces a new bean instance each time one is needed. 
Decleration of the bean's scope attribute to be prototype. 


#### @Singleton
----

If you want Spring to return the same bean instance each time one is needed, 
you should declare the bean's scope attribute to be **singleton**.

The Spring Framework supports the following five scopes, three of which are available only if you use a web-aware ApplicationContext.

##### @Service
----

The annotated class is a "Service"
This annotation is a general-purpose stereotype.
This annotation serves as a specialization of @Component.

#### @Component
----

Allowing for implementation classes to be autodetected through classpath scanning.
