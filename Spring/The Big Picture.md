## Spring - The Big Picture

#### Presentation layer

This is most likely to be a web tier. 
This layer should be as thin as possible. 
It should be possible to have alternative presentation layers — such as a web tier or remote web services facade
— on a single, well-designed middle tier.

#### Business services layer
This is responsible for transactional boundaries and providing an entry point for operations on the system as a whole. 
This layer should have no knowledge of presentation concerns, and should be reusable.

#### DAO interface layer 
This is a layer of interfaces independent of any data access technology that is used to find and persist persistent objects. This layer effectively consists of Strategy interfaces for the Business services layer. 
This layer should not contain business logic. 
Implementations of these interfaces will normally use an O/R mapping technology or Spring's JDBC abstraction.

####  Persistent domain objects
These model real objects or concepts such as a bank account.

#### Databases and legacy systems 
By far the most common case is a single RDBMS. However, there
may be multiple databases, or a mix of databases and other transactional or non-transactional legacy
systems or other enterprise resources. The same fundamental architecture is applicable in either case.
This is often referred to as the EIS (Enterprise Information System) tier.
In a J2EE application, all layers except the EIS tier will run in the application server or web container. 
Domain objects will be passed up to the presentation layer, which will display data they contain, but not modify
them, which will occur only within the transactional boundaries defined by the business services layer. 
