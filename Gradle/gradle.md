

Dependencies Cyclic using the JAR.

Running the 
./gradlew interaction:webapp:dependencies >out.txt

Creates a file with all the dependencies after the build.gradle
It allows find all the cyclic dependencies each of the jars that create a cyclic dependencies should be excluded in the 'build.gradle'
