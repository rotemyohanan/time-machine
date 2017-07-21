
### REST
Representational State Transfer.

##### principles

stateless, client-server, cacheable communications protocol 

HTTP protocol is used REST
Format to connect between machines in a network system.
Enables calls between machines.
Use HTTP requests to post data 

REST architectural constraints certain architectural properties are induced: 
 - Performance
 - Scalability
 - Simplicity
 - Modifiability
 - Visibility
 - Portability
 - Reliability

**REST** is a lightweight alternative to mechanisms like **RPC** (Remote Procedure Calls) and Web Services (SOAP, WSDL, et al.)

Simple and fully featured everything can be done using the REST.


RESTful systems typically, communicate over Hypertext Transfer Protocol (HTTP)

Much like Web Services, a REST service is:
- Platform-independent (you don't care if the server is Unix, the client is a Mac, or anything else),
- Language-independent (C# can talk to Java, etc.),
- Standards-based (runs on top of HTTP), and Can easily be used in the presence of firewalls.

Like Web Services, REST offers no built-in security features, encryption, session management, QoS guarantees, etc. 
But also as with Web Services, these can be added by building on top of HTTP:

For security, username/password tokens are often used.
                        
For encryption, REST can be used on top of HTTPS (secure sockets).
... etc.

One thing that is not part of a good REST design is cookies.
Good REST design operations are **self-contained**,
Each request carries with it (transfers) all the information (state) that the server needs in order to complete it.
                        
The formal REST constraints are:
 - Client–server - A uniform interface separates clients from servers.
 - Stateless
    
 > Uniform interface- this is fundamental to the design of any REST service.
    
URI
Internal media type - ussually Json

Benefits:    
Has a format to the GET/POST method

GET - Reading data  (~ getter)
POST - changes data (~ setter)
PATCH - updating part of the data in the entity

 1. API cleaner and easier to understand. 
 2. Sync data with a website. depends heavily on the code.
 3. Enable uniform caching
    
##### JAX-RS
                        
Java API for RESTful Web Services.
    
Uses annotations to simplified the developement and deployment, aid in mapping a resource class (a POJO) as a web resource
no configuration is necessary to start using JAX-RS, 'web.xml' deployment descriptor is required.

    
Http cookies:
    a small piece of data sent from a website and stored in the user's web browser while the user is browsing
    Every time the user loads the website, the browser sends the cookie back to the server to notify the user's previous activity
    Cookies were designed to be a reliable mechanism for websites to remember stateful information  
        record user browsing activities.
        Cookies can also store passwords and form content a user has previously entered, such as a credit card number or an address.

        
        
Resources:
usually the division is by the domains.

The resources package is in the following path:
 
   '/interaction/webapp/grails-app/resources'

    Server = Maps.googleApis.com
    Resource = Maps / API / GEOCODE / JSON


filter in the http command:   ?fields=id,name,likes   // filtering the json data returns 
The return object of the REST call is a **JSON array**
GET - 
POST - 
    Postman - rest client 


Downloads are done through the 'dl.bintray.com' domain, or ':subject.bintray.com' for Professional accounts

//////////////////////   POSTMAN   //////////////////////
// Using the postman:
1. Choose the method GET/DELETE/PUT ...
2. write in the command line 'https://api.bintray.com/repos/:subject'
3. Define the Authorization as a Basic Auth   // Be aware if it is localhost / Staging / Production
4. Press 'Send' button on the write.
/////////////////////////////////////////////////////////

'https://api.bintray.com'
UserName: rotem
Passsword: Private API key
    
PUT - upload
GET - Download

When you become a premium user in Bintray, your account holds unique, internal, private and public keys. 
The URL you decide to sign, will be encrypted and decrypted with those keys

// When running the REST API in the local host it translates the address to the following address:
'ḩttps://localhost:8443/interaction/api/v1/'

// Get Repositories
curl 'https://api.bintray.com/repos/rotem' // by default the method is GET


A MIME attachment with the content type "application/octet-stream" is a binary file. Typically, it will be an application or a document that must be opened in an application, such as a spreadsheet or word processor No matter what kind of file it is, an application/octet-stream attachment is rarely viewable in an email or web client

FTP is an acronym for File Transfer Protocol. FTP is used to transfer files between computers on a network.
