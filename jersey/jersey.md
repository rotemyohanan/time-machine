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
    enable(TestProperties.LOG_TRAFFIC);
    enable(TestProperties.DUMP_ENTITY);
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



### @Context

    @Context Request request;
    
Inject our own objects into a resource?
Bundles HK2 (built in Jersey) is capable of that. Requirees only a binder in the ResourceConfig


Writing a REST call tests:
    
    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        Entity<Book> bookEntity = Entity.entity(book, MediaType.APPLICATION_JSON_TYPE);
        Response response = target("books").request().post(bookEntity);
        
        assertEquals(200, response.getStatus());
        Book responseBook = response.readEntity(Book.class);
        assertNotNull(responseBook.getId());
        assertEquals("title",responseBook.getTitle());
        assertEquals("author",responseBook.getAuthor());
    }

    


@ManagedAsync

This method should be run on a Jersey managed thread. 


JSON provider: jackson-jaxrs-json-provider

    public class BookApplication extends ResourceConfig {
        
        JacksonJsonProvider json = new JacksonJsonProvider().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        
        package("com.pluralsight");
        register((AbstractBinder) () -> {bind(dao).to(BookDao.class); });
        register(json);
    
    }

