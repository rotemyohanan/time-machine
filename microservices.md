The old way:
Monolithic app packaged in 1 war and deployed.
All the code is tied together. (increase developmenet time)

The WAR is deployed to the App Server(JBOSS, Tomcat, WebLogic)

--------------------------------------------------
Big App == Big code base == increase load time IDE
--------------------------------------------------

Best way to deploy microserivces based app is inside a container.
container virtualization.
virtual operating system env.


Sharding: data partitioned.

app redirect request to corresponding shared base input.

Benefits:

1. Large App unaffected by single module failure.
2. Legacy code can be rewrite (loosely coupled)
3. Less code = more flexibility.
4. Enable build the app with different languages.


Drawbacks:

1. Developing distributed systems can be complex.
2. Multiple databases and transaction management can be painful.
3. Testing a microservices-based application can be cumbersome, Using the monolithic approach, we would just need to launch our WAR on an application server and ensure its connectivity with the underlying database. But now, each dependent service needs to be confirmed before you can start testing.
4. Deploying microservices can be complex. 
