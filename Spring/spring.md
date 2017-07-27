


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
    
    
The technology that Spring is most identified with is **Inversion of Control**, and specifically the **Dependency
Injection** flavor of Inversion of Control. 



Logging:
========
The mandatory logging dependency in Spring is the Jakarta Commons Logging API (JCL)    
This is a backward compatible.    
The way we do this is to make one of the modules in Spring depend explicitly on 'commons-logging'.




#### Releases:
-------
BUILD-SNAPSHOT - current snapshots

M1, M2 etc. - milestones

RC1, RC2 etc. - release candidates

RELEASE - GA release

SR1, SR2 etc. - service releases

In its core, REST defines that a system consists of resources that clients interact with. Spring MVC offers a solid foundation to build theses kinds of services. But implementing even the simplest tenet of REST web services for a multi-domain object system can be quite tedious and result in a lot of boilerplate code.

**Spring Data REST builds on top of Spring Data repositories**

    
