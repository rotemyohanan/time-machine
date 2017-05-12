Docker-machine commands

IP addresses for Docker hosts
=============================
For each machine you create, the Docker host address is the IP address of the Linux VM.

    docker-machine create
    docker-machine ls    // list the machines you have created.
    docker-machine ip <machine-name>    // returns a specific host’s IP address.


docker-machine ls:

    docker-machine env <machine-name>   //outputs the configuration command you should use.


What is Docker Machine?

Docker Machine is a tool that lets you install Docker Engine on virtual hosts, and manage the hosts with docker-machine commands. (create Docker hosts, start, inspect, stop, and restart, upgrade the Docker client and daemon, configure a Docker client to talk to your host)

    run 'docker-machine env default'  //point to a host called default. (follow on-screen instructions to complete env setup)     
    run 'docker ps'
    'docker run hello-world' ...

Machine was the only way to run Docker on Mac or Windows previous to Docker v1.12. Starting with the beta program and Docker v1.12, Docker for Mac and Docker for Windows are available as native apps and the better choice for this use case on newer desktops and laptops. We encourage you to try out these new apps. The installers for Do



cloud providers:AWS/Digital Ocean.
