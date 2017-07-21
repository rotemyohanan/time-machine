
    @Bean // Is used to define a custom bean.

    <context:annotation-config />
    <context:component-scan base-package="com.pluralsight"> 

Main Steretype Spring annotations:

    @Component 
    @Service  (extends @Component) // holds the business logic layer
    @Repository  (extends @Component) // holds the data layer

In the application the **@component** defines the class as a **Bean**.

    @Repository("customerRepository")  // the customerRepository is the @Repository's name
    @Service("customerService")        // the customerService is the @Service's name
    
#### Autowired
    @Autowired


#### EnableAutoConfiguration

@EnableAutoConfiguration

@Import(EnableAutoConfigurationImportSelector.class)

SpringFactoriesLoader.loadFactoryNames(...)

/META-INF/spring.factories    // this is a properties file
