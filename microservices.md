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




> Differetnt processes

> Common characteristics for a microservice:

1) Componentization via service
2) Organized around business capabilities - microservice should have a common business capability it is not organized around technology.
3) Product not Project
4) Smart endpoints and dumb pipes - there should not be a logic shared between services
5) Decentralized Governance
6) Decentralization Data Management - Every service should manage its own data and its own business logic.
7) Infrastructure Automation - monitoring the process
8) Design for failure - there will be failures  so mange them.
9) Evolutionary Design

#### Components:
Software should be break into components. 
What is component? something can be replace independant with others.

#### Service: 
Running a specific process.

##### SOA

SOA? - Service Oriented Architecture

##### How Big is the microservice?

No good answer

##### Microservices advantages

- Enable partial deployment
- Availability is better when using microservice - it is easier to maintain.
- Preserve modularity
- Multiple platforms

##### Monolith advantages
- is more consistent.
- is more easy to refactor.

Needs:
- Rapid provisioning
- Basic Monitoring
- Rapid application deployment
- Devops culture

### Links

https://www.youtube.com/watch?v=wgdBVIX9ifA

