

Grails Framework
Grails builds on these concepts and dramatically reduces the complexity of building web applications on the Java platform. by building on already established Java technologies like Spring and Hibernate.
Grails is a full stack framework

Grails 2.4 comes with: 
Groovy 2.3
Spring 4.0.4 
Hibernate 4.3.5

Assets should now live in  grails-app/assets. 
Three folders are made for you by default:
javascript
stylesheets
images

This library dependency is required in grails-app/conf/BuildConfig.groovy 

The views for namespace controllers may now be defined in the grails-app/views/<namespace name>/<controller name>/ directory
grails supports async programming  - allows async processing of requests



Define GRAILS_HOME
export GRAILS_HOME=/path/to/grails
add the bin directory to your PATH variable
export PATH=“$PATH:$GRAILS_HOME/bin


In Grails, whenever you want a new page you just create a new controller action for it


Grails applications can be run with the built in Tomcat server using the run-app command which will load a server on port 8080 by default.

specify a different port by using the server.port argument:
grails -Dserver.port=8090 run-app

Testing an application
The create-* commands in Grails automatically create unit or integration tests for you within the test/unit or test/integration directory




2.10 Deploying an Application

Grails applications are deployed as Web Application Archives (WAR files), 
The war command for performing this task:   grails war
This will produce a WAR file under the target directory

Unlike most scripts which default to the development environment unless overridden, the war command runs in the production environment by default. 



6. Command Line

It's often useful to provide custom arguments to the JVM when running Grails commands. 
In particular with run-app where you may for example want to set a higher maximum heap size. The Grails command will use any JVM options provided in the general JAVA_OPTS environment variable, but you can also specify a Grails-specific environment variable too:

export GRAILS_OPTS="-Xmx1G -Xms256m -XX:MaxPermSize=256m"
grails run-app

Gant
A Gant script itself is similar to a regular Groovy script except that it supports the concept of "targets" and dependencies between them



Keep reading from:   7. GORM

14 Testing
Automated testing is a key part of Grails. Hence, Grails provides many ways to making testing easier from low level unit testing to high level functional tests.
