



Spring
Dependency Management and Naming Conventions
Dependency management and dependency injection are different things. To get those nice features of Spring into your application (like dependency injection) you need to assemble all the libraries needed (jar files) and get them onto your classpath at runtime, and possibly at compile time.
    These dependencies are not virtual components that are injected, but physical resources in a file system (typically).
    
    
Logging:
========
The mandatory logging dependency in Spring is the Jakarta Commons Logging API (JCL)    
This is a backward compatible.    
The way we do this is to make one of the modules in Spring depend explicitly on 'commons-logging'.
    
