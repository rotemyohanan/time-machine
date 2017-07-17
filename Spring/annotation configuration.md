

<context:annotation-config />
<context:component-scan base-package="com.pluralsight"> 


3 main annotation for Spring annotation

Steretype annotation:

    @Component 
    @Service  (extends @Component) // holds the business logic layer
    @Repository  (extends @Component) // holds the data layer

In the application the **@component** defines the class as a **Bean**.


    @Repository("customerRepository")  // the customerRepository is the @Repository's name
    @Service("customerService")        // the customerRepository is the @Repository's name
