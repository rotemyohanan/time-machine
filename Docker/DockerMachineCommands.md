Docker-machine commands

IP addresses for Docker hosts
=============================
For each machine you create, the Docker host address is the IP address of the Linux VM.

    docker-machine create
    docker-machine ls    // list the machines you have created.
    docker-machine ip <machine-name>    // returns a specific host’s IP address.


docker-machine ls:


'docker-machine env <machine-name>'  subcommand outputs the configuration command you should use.
