

// ------------------------------  Sharding ----------------------------- //
/*
Sharding is a method for storing data across multiple machines. 
MongoDB uses sharding to support deployments with very large data sets and high throughput operations.

Purpose of Sharding

Database systems with large data sets and high throughput applications can challenge the capacity of a single server. 
High query rates can exhaust the CPU capacity of the server. Larger data sets exceed the storage capacity of a single machine. Finally, working set sizes larger than the system’s RAM stress the I/O capacity of disk drives

The data is set in centeral locations(server computers)

Protocol buffer:
Protocol Buffers is a method of serializing structured data. 
It is useful in developing programs to communicate with each other over a wire or for storing data. 
Serializing data structure - smaller faster and simpler than xml.
I can define how you want your data to be structured.

The apache web server:
a ‘container’ application (Tomcat) can be used to make the application (servlet) available to apache (deploying).

RPC: Remote Procedure Calls
*/

class directExecutor implements Executor {
    
    public void execute(Runnable runnable) {
        runnable.run()
    }
}
