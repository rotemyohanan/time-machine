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

#### Docker layers

Each Docker image references a list of read-only layers that represent filesystem differences. 
Layers are stacked on top of each other to form a base for a container’s root filesystem. 

The Docker storage driver is responsible for stacking these layers and providing a single unified view.

When you create a new container, you add a new, thin, writable layer on top of the underlying stack. 
This layer is often called the “container layer”. All changes made to the running container - such as writing new files, modifying existing files, and deleting files - are written to this thin writable container layer. 



--------------------------------------------------


### Docker file
Contains instruciotns for building a Docker image.

Keywords:
From --> indicates the base image from which the container is built.
Run --> indicates the command that needs to be executed on the image.

##### Buiding an image commands
```javascript
    docker build -t <image-name>:tag
```

```javascript
    docker run --name "container-name" -p <host port>:<container port> <image_name:tag>
```

### Docker image
Based on many layers.
Each image has a tag represents the image.


### Docker Volumes
Special type of directory in a container typically referred as a "data volume"
Can be shared and reuse among containers
Update of an image will not affect a data volume
Data volumes are persisted even after the container is deleted

Creating a volume:
```javascript
docker run -p 8080:3000 -v $(pwd):/var/www node

-v : create a volume
$(pwd) : host location
/var/www : container volume
```

Running ```docker inspect mycontainer``` for getting information about the container.

### Docker host
Hosting the container


### Remove the container
```docker container rm -f $(docker ps -qa) ```


