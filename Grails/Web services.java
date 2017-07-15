// -------------------------------- WEB SERVICES --------------------------------- //
/*
    Web Services are all about providing a web API onto your web application.
    
REST is not really a technology in itself, but more an architectural pattern. REST is very simple and just involves using plain XML or JSON as a communication medium, combined with URL patterns that are "representational" of the underlying system, and HTTP methods such as GET, PUT, POST and DELETE.

Each HTTP method maps to an action type. 
For example:
GET : retrieving data. 
POST: creating data. 
PUT : updating data.
DELETE ...

Grails includes flexible features that make it easy to create RESTful APIs
Creating a RESTful resource can be as simple as one line of code.

*/

//9.1.1 Domain classes as REST resources

//Expose a domain class as a REST resource (by adding the grails.rest.Resource transformation to any domain class)
add grails.rest.Resource
import grails.rest.*
@Resource(uri='/books') // This is the transformation
class Book { // Domain class is available as a REST resource

    String title

    static constraints = {
        title blank:false
    }
}


// (1--)The transformation will automatically register the necessary RESTful URL mapping and create a controller called BookController
@Resource(uri='/books', readOnly=true)  // Read only attr

//The link tag offers an easy way to link to any domain class resource.
<g:link resource="${book}">My Link</g:link>

//getObjectToBind() method returns the request object
class RestfulController<T> {
    def update() {
        T instance = // retrieve instance from the database...
        instance.properties = getObjectToBind()
    }
}


// The RESTful URL mapping and create controller called BookController.
// URL http://localhost:8080/myapp/books/1
// XML Response
<?xml version="1.0" encoding="UTF-8"?>
<book id="1">
    <title>The Stand</title>
</book>

// JSON response
{"id":1,"title":"The Stand"}

// Choosing the format JSON / XML
@Resource(uri='/books', formats=['json', 'xml'])
class Book {
    …
}

//9.1.5.1 Extending the RestfulController super class
//The easiest way to get started doing so is to create a new controller for your resource that extends the grails.rest.RestfulController super class. For example:
class BookController extends RestfulController {
    static responseFormats = ['json', 'xml']
    BookController() {
        super(Book)
    }
}
