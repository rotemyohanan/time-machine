// Get Grails version
grails -version
// General syntax
grails [command name]

// Creating application 
grails create-app myapp

// Debug application
grails -debug run-app

cd myapp
grails create-pom com.mycompany
mvn package

grails create-app myapp
grails create-plugin plugin-a
grails create-plugin plugin-b
grails create-multi-project-build com.mycompany:parent:1.0-SNAPSHOT

// Creating a controller
grails create-controller <controller-name>

// ---------  Testing ----------- //
grails test-app  [class name | package name | method name (class.method)] //   Runs app tests
-clean           // [optional] cleaing before running test

// Getting into grails
grails

// running external process while interactive mode runs
!ls
// Stop app
stop-app

// Create your own Gant scripts
grails create-script compile-sources // Will create a script called scripts/CompileSources.groovy

// Run
grails run-app
//Testing , Seperate JVM is launched to execute this tests.
grails test-app

// Debugging application
grails test-app --debug-fork // For testing app
grails run-app --debug-fork  // For running app

// Producing war file under the '/target' dir
grails war

// By default the war runs in the production environment 
// Using the dev in the command line defines running in the developement environment 
grails dev war

// generate-all, which will generate a controller (and its unit test) and the associated views:
grails generate-all <package-name.class-name>

//Tell Grails to accept the default answer for any questions, for example whether to install a missing plugin.
grails war --non-interactive

// Open a file
open <file-name> <another-file-name> <other-file-name>

// Maven commands
mvn install

// ---------  Testing ----------- //
grails test-app  [class name | package name | method name (class.method)] //   Runs app tests
-clean           // [optional] cleaing before running test

//running all spock tests
grails test-app :spock
