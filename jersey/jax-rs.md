


## JAX-RS Application, Resources and Sub-Resources (chapter 3)
-----
>JAX-RS is an specification (just a definition). 

>Jersey is a JAX-RS implementation
        
About
-----
Developing RESTful Web services that seamlessly support exposing your data in a variety of representation media types
and abstract away the low-level details of the client-server communication is not an easy task without a good toolkit. 
In order to simplify development of RESTful Web services and their clients in Java, a standard and portable JAX-RS API 
has been designed. 
Jersey RESTful Web Services framework is open source, production quality, framework for developing RESTful Web Services in Java 
that provides support for JAX-RS APIs and serves as a JAX-RS (JSR 311 & JSR 339) Reference Implementation.

Jersey framework is more than the JAX-RS Reference Implementation. 
Jersey provides it’s own API that extend the JAX-RS toolkit with additional features and utilities to further simplify 
RESTful service and client development. 
Jersey also exposes numerous extension SPIs so that developers may extend Jersey to best suit their needs.

### Goals of Jersey project:

 1. Track the JAX-RS API and provide regular releases of production quality Reference Implementations that ships with GlassFish.
 2. Provide APIs to extend Jersey & Build a community of users and developers. 
 3. Make it easy to build RESTful Web services utilising Java and the Java Virtual Machine.
    
Root resource classes are POJOs (Plain Old Java Objects) that are annotated with @Path
    

Using Jersey to annotate Java objects to create RESTful web services.


### JAX-RS Annotations
------
    
**@Path** = relative URI path
----
    
What makes JAX-RS so useful is that you can embed variables in the URIs.
These variables are substituted at runtime in order for a resource to respond to a request based on the substituted URI.
Variables are denoted by curly braces {}
Example:

    @Path("/users/{username}")
    
explain: 
1. A user will be prompted to enter their name.
2. A Jersey web service configured to respond to requests to this URI path template will respond. 

    
**@PathParam** = obtain the value of the username variable
----
@PathParam may be used on method parameter of a request method.

Example:

    @Path("/users/{username}")

    public class UserResource {
 
        @GET
        @Produces("text/xml")
        public String getUser(@PathParam("username") String userName) {
            ...
        }
    }

 > Username must only consist of lower and upper case numeric characters then it is possible to declare a particular regular     expression, which overrides the default regular expression, "[^/]+"
    @Path("users/{username: [a-zA-Z][a-zA-Z_0-9]*}")


Code example (class level):
    
example:
-------
    
    package org.glassfish.jersey.examples.helloworld;
 
    import javax.ws.rs.GET;
    import javax.ws.rs.Path;
    import javax.ws.rs.Produces;
 
    @Path("helloworld")
    public class HelloWorldResource {
        public static final String CLICHED_MESSAGE = "Hello World!";
 
        @GET
        @Produces("text/plain")
        public String getHello() {
            return CLICHED_MESSAGE;
        }
    }



### HTTP Methods (3.1.2. @GET, @PUT, @POST, @DELETE, ... )                    
----

Resource methods: 
    
    @GET, @PUT, @POST, @DELETE and @HEAD.
    
By default the JAX-RS runtime will automatically support the methods **HEAD** and **OPTIONS**.

For **HEAD** the runtime will invoke the implemented **GET** method (if present) and ignore the response entity (if set). 
A response returned for the OPTIONS method depends on the requested media type defined in the 'Accept' header. 
    
#### @Produces
-----

Is used to specify the MIME media types of representations a resource can produce and send back to the client.

Example:

    @Path("/myResource")
    @Produces("text/plain")
    public class SomeResource {
        @GET
        public String doGetAsPlainText() {
            ...
        }
 
        @GET
        @Produces("text/html")
        public String doGetAsHtml() {
                ...
        }
    }

Using multiple output MIME type

        @Produces({"application/xml; qs=0.9", "application/json"})
        public String doGetAsXmlOrJson() {
                ...
        }
    
>In the above sample, if client accepts both "application/xml" and "application/json" (equally), then a server always sends "application/json", since "application/xml" has a lower quality factor.
    
    
#### @Consumes 
----
Is used to specify the MIME media types of representations that can be consumed by a resource. 

Example:

    @POST
    @Consumes("text/plain")
    public void doSomething(String message) {
        // Store the message
    }

>**@PathParam** to extract a path parameter from the path component of the request URL.
>**@QueryParam** is used to extract query parameters from the Query component of the request URL.

Example:
    @Path("smooth")
    @GET
    public Response smooth(
        @DefaultValue("2") @QueryParam("step") int step,
        @DefaultValue("true") @QueryParam("min-m") boolean hasMin,
        @DefaultValue("true") @QueryParam("max-m") boolean hasMax,
        @DefaultValue("true") @QueryParam("last-m") boolean hasLast,
        @DefaultValue("blue") @QueryParam("min-color") ColorParam minColor,
        @DefaultValue("green") @QueryParam("max-color") ColorParam maxColor,
        @DefaultValue("red") @QueryParam("last-color") ColorParam lastColor) {
        ...
    }

All the parameter-based annotations, obey the same rules as @QueryParam:
 - @PathParam
 - @MatrixParam
 - @HeaderParam
 - @CookieParam
 - @FormParam 
    
**@FormParam** is slightly special because it extracts information from a request representation that is of the MIME media type **"application/x-www-form-urlencoded"** and conforms to the encoding specified by HTML forms.
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void post(@FormParam("name") String name) {
        // Store the message
    }

Example 3.11. Obtaining general map of URI path and/or query parameters

    @GET
    public String get(@Context UriInfo ui) {
       MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
       MultivaluedMap<String, String> pathParams = ui.getPathParameters();
    }

Example 3.12. Obtaining general map of header parameters


    @GET
    public String get(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        Map<String, Cookie> pathParams = hh.getCookies();
    }



**@BeanParam** 
Allows to inject the parameters described above into a single bean. 
A bean annotated with **@BeanParam** containing any fields and appropriate param annotation(like @PathParam) will be initialized with corresponding request values in expected way as if these fields were in the resource class. Then instead of injecting request values like path param into a constructor parameters or class fields the @BeanParam can be used to inject such a bean into a resource or resource method. The @BeanParam is used this way to aggregate more request parameters into a single bean.
    
    
Example:

Example 3.14. Example of the bean which will be used as @BeanParam

public class MyBeanParam {
    @PathParam("p")
    private String pathParam;
 
    @MatrixParam("m")
    @Encoded
    @DefaultValue("default")
    private String matrixParam;
 
    @HeaderParam("header")
    private String headerParam;
 
    private String queryParam;
 
    public MyBeanParam(@QueryParam("q") String queryParam) {
        this.queryParam = queryParam;
    }
 
    public String getPathParam() {
        return pathParam;
    }
    ...
}


// ------------------------------------ //
//   Chapter 4 - Jersey documentation   //
// ------------------------------------ //
