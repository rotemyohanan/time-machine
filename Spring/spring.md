


### Spring overview

The same development **without EJB**. 
Spring is for **Enterprise development without using an application server**.
**Tomcat** is a **web server** it is **not an application server**. (Tomcat is lightwight)

Spring is POJO based. // Plain old Java Object. Hence Spring is:
 - Cleaner
 - Easier
 - Quicker
 - Build around best practices. (Singeltons Factories, Pattern annotation based).
 - Manage downloads using Maven / Gradle

Spring increases:
 - testability 
 - mainainability 
 - scalability

Spring reduces the complex of the code and help to focus on the business focus.
Complex code done faster and remove the complexity.
Java is using JDBC (which is not that pretty)
 > Spring 4 requires using JAVA 8.


#### What is Spring?

Dependency Management and Naming Conventions. (Dependency management and dependency injection are different things).

> Make sure all the required Spring features you need to assemble all the libraries needed (jar files) and get them onto your classpath at runtime, and possibly at compile time.

These dependencies are not virtual components that are injected, but physical resources in a file system (typically).
    
    
Logging:
========
The mandatory logging dependency in Spring is the Jakarta Commons Logging API (JCL)    
This is a backward compatible.    
The way we do this is to make one of the modules in Spring depend explicitly on 'commons-logging'.
    
