
#Docker Network

###Default Networks

After installation of Docker, 3 networks are automatically created.

    docker network ls

|NETWORK ID        |  NAME        |       DRIVER       |
|------------------| :-----------:| :-----------------:|
|7fca4eb8c647      |  bridge      |       bridge       |
|9f904ee27bf5      |  none        |       null         |
|cf03ee007fb4      |  host        |       host         |


Using the **--network** flag to specify which networks your container should connect to.

The bridge network represents the **docker0** (present in all Docker installations).

    docker run --network=<NETWORK>

The bridge is a part of a host’s network stack. 
By using the **ifconfig** command on the host.

    $ ifconfig

    docker0   Link encap:Ethernet  HWaddr 02:42:47:bc:3a:eb
          inet addr:172.17.0.1  Bcast:0.0.0.0  Mask:255.255.0.0
          inet6 addr: fe80::42:47ff:febc:3aeb/64 Scope:Link
          UP BROADCAST RUNNING MULTICAST  MTU:9001  Metric:1
          RX packets:17 errors:0 dropped:0 overruns:0 frame:0
          TX packets:8 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:0
          RX bytes:1100 (1.1 KB)  TX bytes:648 (648.0 B)
------
The host network adds a container on the host’s network stack


    docker network inspect
Returns information about a network.

