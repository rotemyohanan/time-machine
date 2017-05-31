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

    'docker-machine env default'  //point to a host called default. (follow on-screen instructions to complete env setup)     
    'docker ps'
    'docker run hello-world' ...

Machine was the only way to run Docker previous to Docker v1.12. 
Docker is available as native apps and the better choice for this use case on newer desktops and laptops. 


    docker run -d --name web -p 8080:8080 <path>
    The name of the conteiner is web
    
    8080 in the host is contacting with 8080 inside the container
    
That will return a unique Id of the container.

    docker stop web
stops the contianer form running
   
   
Getting into a container:

    docker exec -it <containerId> bash
Get out of the container:
     
     exit

=============================================

cloud providers:AWS/Digital Ocean.
