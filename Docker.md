# Docker

***
VM is parallel to a virtual server.
VM slices of the physical server means if I have 4 VMs I have 1/4 of the computer's CPU,Memory and Disk.
4 installations of Operating Systems. Each one take a slice from the physical hardware power.
and that is only for the OS not even give any power to the application.
Hypervisor cons:
Each VM is eating the computer memory CPU and Disk. system resources.
***

### Conatainers

instead of installing a Hypervisor, we install only 1 Operating system. On top of that we create 4 containers.
The app is installed and running inside each one of the containers.
This is lightweight than the VM and that enables more free space to the business 

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

