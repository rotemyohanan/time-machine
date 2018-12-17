

### Proxy  (Many clients and 1 server)

Proxy is a server that hides the identity of the clients.
```http/80 ```

This definese in the header of the request.

The proxy do the request to the server.
The server does not know who the client is.
the response is back to the proxy and not directly to the client.

Advantages:
----
- Anonymity
- Caching
- Block unwanted sites
- GeoFencing - certain clients can have access for certain servers.


### Reverse Proxy  (Many servers and 1 client)

Type of proxy used by the server

The client does not know who is the server he is connecting to.


Advantages:
----
- Anonymity
- Caching
- Isolating internal traffic, client is not expose to the internal architecture.
- Logging - Monitoring which server is down or up.
- Canary deployment




### Nginx

Server side discovery & Load balancer

