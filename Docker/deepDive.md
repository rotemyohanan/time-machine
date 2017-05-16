#Docker Deep Dive

To each application should be a server 1:1 ratio
For every application we should buy and build a related server for it.

The containers enable run few OS in 1 computer which behave as number of servers.

Containers under the hood:
------

Container is an isolated instance of a user space.
For each container there is an isolated view of the file system tree. Each container has its own view for the file system.
Each file changes in 1 container does not affect the file system for other containers.

Each container hes its own IP own network stack trace own port range own routing table.

How it happens?
###Kernel Namespaces

The isolation is happened thanks to the linux kernel feature calls Namespaces.
The namespaces enable partitioning, each namespace is related to a container.

The user namespace enable to have different permissions inside the container but not out side the container.

###Kernel Control Groups(cgroups)

group together sources and apply limits (like quality of service rules)

###Kernel Capabilties

Docker provides a standard runtime. 
Developers can code up and upload the code to the container, as long as the destination is running a docker.


