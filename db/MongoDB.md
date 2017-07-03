  
# MongoDB

short
Running the server.
Create dir where all the data files are stoered into.  
> ‘\data\db’
 
Port: 27017 (default)
 
**Mongod** : is the command in the shell.  (Mongo deamon)

 
#### Atomicity and Transactions:
----

In MongoDB, a write operation is atomic on the level of a **single document**. 
(even if the operation modifies multiple embedded documents within a single document)
When a single write operation modifies multiple documents, the modification of each document is atomic, but the operation as a whole is not atomic and other operations may interleave.

There is an ability to isolate a single write operation that affects multiple documents using the **$isolated** operator.
**$isolated** prevent other processes from interleaving once the write operation modifies the first document.
This ensures that no client sees the changes until the write operation completes or errors out.

 > Note:   
 > $isolated does not work with sharded clusters.
 > An isolated write operation does not provide “all-or-nothing” atomicity. That is, an error during the write operation does not roll back all its changes that preceded the error.


