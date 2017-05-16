# Docker

***
VM is parallel to a virtual server.
VM slices of the physical server means if I have 4 VMs I have 1/4 of the computer's CPU,Memory and Disk.
4 installations of Operating Systems. Each one take a slice from the physical hardware power.
and that is only for the OS not even give any power to the application.
Hypervisor cons:
Each VM is eating the computer memory CPU and Disk. system resources.

Hypervisors revolutionized IT.
***

### Conatainers

instead of installing a Hypervisor, we install only 1 Operating system. On top of that we create 4 containers.
The app is installed and running inside each one of the containers.
This is lightweight than the VM and that enables more free space to the business 

Docker Containers are persistent by nature. 
  - Stop does not wipe the container data.
  - Restarting a container brings its data back.



---
Pros:
 * Containers are generally more lightweight than virtual machines.
 * Starting and stopping containers is extremely fast. 

---
Most common development machines don't have a containerization system built-in. 
Docker uses a virtual machine with Linux installed to provide that.



Docker Host?

docker image?
a Stoped or power off container - represent a specific point in time. the image contains a container.

The public IP is for conecting the web server.  
 
     <ip>:8080

----

### Docker (dock worker)

Docker Inc: the main company behind Docker technology.
Platform as a service provider dotCloud. runs above AWS.

docker - container technology.

____
##### The Docker Project

This is not owned by Docker INC but owned by the community.

Docker is open source (Apache License 2.0)
Ships and runs modern applications better.

**Docker Engine ** 
Is a small piece of software for building images and running containers.
This is the core technology that runs containers.



Docker is written in Golang.

**DockerHub** public docker registry where you can store docker images.
To find an image - go to the DockerHub.
The official Docker registry.


    docker pull mongo  // pull is like download 
    
###### Registry security

DTR = Docker Trusted Registry
Quay Enterprise

Pay for support contract from the Docker Inc.

###### Automated workflow:


------------------------
#### The Docker daemon
The Docker daemon (dockerd) listens for Docker API requests and manages Docker objects such as images, containers, networks, and volumes.

#### The Docker client
The Docker client (docker) is the primary way that many Docker users interact with Docker. 

#### Docker registry
A Docker registry stores Docker images. 
Docker Hub and Docker Cloud are public registries that anyone can use, and Docker is configured to look for images on Docker Hub by default.

    docker pull 
    docker run 
    
The required images are pulled from your configured registry.
