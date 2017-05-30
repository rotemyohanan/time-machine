

## Running tests from command line
----

##### Compile

    ./gradlew clean; java interaction/webapp/src/test
    
    // java command means running as an application.
When running test suite inside the IDE, i should add the flag 
    '-Dtest=src/test/Foo.groovy'


// Running integration tests

    ./gradlew clean; interacation:webapp:integrationTest --tests com.jfrog.bintray.interaction.service.download.DownloadServiceIntegrationSpec


    grails run-app [command-name]

    ./gradlew clean interaction:webapp:integrationTest --tests com.jfrog.bintray.interaction.service.download.DownloadServiceIntegrationSpec

Dependency into a file:
    
    ./gradlew interaction:webapp:dependencies > tree.log
