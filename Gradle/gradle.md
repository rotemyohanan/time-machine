


## Gradle
-----
Gradle is a building tool - brings files from remote.

Everything in Gradle sits on top of two basic concepts: 
 1. projects
 2. tasks
 
Every Gradle build is made up of one or more projects
Each project is made up of one or more tasks.
A task represents some atomic piece of work which a build performs.

##### Tasks examples:
1. compiling some classes 
2. creating a JAR
3. generating Javadoc
4. publishing some archives to a repository.

The gradle command looks for a file called **build.gradle** in the **current directory**. 

##### build.gradle:

File a build script (it is a build configuration script)
The build script defines a project and its tasks


    gradle hello // Gradle executes the hello task.

    gradle build // Gradle will compile and test your code, create a JAR file containing your main classes and resources.

    gradle clean // Deletes the build directory, removing all built files.

    gradle assemble // Compiles and jars your code, but does not run the unit tests. 
                    // Other plugins add more artifacts to this task. 
                    // For example, if you use the War plugin, this task will also build the WAR file for your project.

    gradle check    // Compiles and tests your code. 
    
Other plugins add more checks to this task. 
For example: if you use the checkstyle plugin, this task will also run Checkstyle against your source code.

Usually the JAR file needs to be published somewhere.
In Gradle, artifacts such as JAR files are published to repositories (local directory / remote location / multiple location)

Publishing a jar file

    gradle uploadArchives

Project webservice is a webapp which returns XML
Gradle used Apache Ivy for its dependency management.

Ivy dependencies need to be specified in the **ivy.xml** file
    
    <ivy-module version="2.0">
    <info organisation="org.apache" module="java-build-tools"/>
    <dependencies>
        <dependency org="junit" name="junit" rev="4.11"/>
        <dependency org="org.hamcrest" name="hamcrest-all" rev="1.3"/>
    </dependencies>
    </ivy-module>

#### BUILD.XML  

##### MAVEN

    <project xmlns:ivy="antlib:org.apache.ivy.ant" name="java-build-tools" default="jar">
        <property name="src.dir" value="src"/>
        <property name="build.dir" value="build"/>
        <property name="classes.dir" value="${build.dir}/classes"/>
        <property name="jar.dir" value="${build.dir}/jar"/>
        <property name="lib.dir" value="lib" />
        <path id="lib.path.id">
             <fileset dir="${lib.dir}" />
        </path>
        <target name="resolve">
            <ivy:retrieve />
        </target>
        <target name="clean">
            <delete dir="${build.dir}"/>
        </target>
        <target name="compile" depends="resolve">
            <mkdir dir="${classes.dir}"/>
            <javac srcdir="${src.dir}" destdir="${classes.dir}" classpathref="lib.path.id"/>
        </target>
        <target name="jar" depends="compile">
            <mkdir dir="${jar.dir}"/>
            <jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}"/>
        </target>
    </project>

##### Gradle

    apply plugin: 'java'
    apply plugin: 'checkstyle'
    apply plugin: 'findbugs'
    apply plugin: 'pmd'
 
    version = '1.0'
 
    repositories {
        mavenCentral()
    }
 
    dependencies {
        testCompile group: 'junit', name: 'junit', version: '4.11'
        testCompile group: 'org.hamcrest', name: 'hamcrest-all', version: '1.3'
    }


    ./gradlew idea // building the Idea
    ./gradlew build // builds the project using the 'gradle.build' file

Dependencies Cyclic using the JAR.

    ./gradlew interaction:webapp:dependencies > out.txt

Creates a file with all the dependencies after the **build.gradle**
It allows find all the **cyclic dependencies** each of the jars that create a cyclic dependencies should be excluded in the **'build.gradle'**

