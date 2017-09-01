

### Read all the environment variables

    printenv
    
    
#### Set the environment variables into the following files:

    ~/.profile
    ~/.bashrc
    ~/.bash_profile


#### System wide definition

    /etc/environment
    /etc/profile.d
    
    
### JAVA

set in the ~/.profile file:

    JAVA_HOME="/opt/java/jdk1.8.0_144"
    GRADLE_HOME="/.sdkman/candidates/gradle/4.1"
    PATH="$PATH:$JAVA_HOME/bin:$GRADLE_HOME/bin"
