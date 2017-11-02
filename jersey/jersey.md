Jersey annotation service makes it easy to do routing, injection, and other functions important to a RESTful web application.


### Jersey 1

com.sun.jersey.server.impl...

### Jersey 2

org.glassfish.jersey.*


Grizzly http container
Grizzly leverage the java io api, easy to create and scale a rubust servers.

A simple way to configurer and deploy a server.
No web.xml


**ResourceConfig** class is used to scan the components. (scan in a pkg, file).
Using the custom JAX-RS components by **register()**

For MAVEN project.
1. Go to the Intellij IDEA
Rub/Debug Configurations
on the command line: add clean compile exec:java


JerseyTest:

Configure the container:


Configure the client()

target - represent the endpoint.

    response.readEntity(Book.class);

Maven test in the intellij idea
run configurations , command line: test

Tests syntax:

    MyResourceTest extends JerseyTest


    protected Application configure() {
      return new ResourceConfig().packages("com.pluralsight");
    }


    @Test
    public void testGetBook() {
      Book response = target("books").path("1").request().get(Book.class);
    }

    @Test
    public void testGetBooks() {
      Collection<Book? response = target("books").request().get(new GenericType<Collection<Book>>(){});
      assertEqulas(2, response.size());
    }
