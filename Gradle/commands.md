

## Running tests from command line
----

##### Compile

    ./gradlew clean; java interaction/webapp/src/test
**java** command means launching (running) a Java application.
The java command starts a Java application. It does this by starting a Java runtime environment, loading a specified class, and calling that class's main method.

Options:

**-jar** option is specified, then the first non-option argument is the name of a JAR file containing class and resource files for the application, with the startup class indicated by the Main-Class manifest header.

The Java runtime searches for the startup class, and other classes used, in 3 sets of locations: 
1. The bootstrap class path
2. The installed extensions
3. The user class path.

The **javaw** command is identical to java. except that with javaw there is no associated console window. 
Use **javaw** when you do not want a command prompt window to appear.

----

When running test suite inside the IDE:
Add the flag 

    '-Dtest=src/test/Foo.groovy'

----
Running integration tests

    ./gradlew clean; interacation:webapp:integrationTest --tests com.jfrog.bintray.interaction.service.download.DownloadServiceIntegrationSpec


    grails run-app [command-name]

    ./gradlew clean interaction:webapp:integrationTest --tests com.jfrog.bintray.interaction.service.download.DownloadServiceIntegrationSpec

----
Dependency into a file:
    
    ./gradlew interaction:webapp:dependencies > tree.log
