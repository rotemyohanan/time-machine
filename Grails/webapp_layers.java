// --------------  Grails Web Layers  -------------- //
/*
A controller fulfills the C in the Model View Controller (MVC) pattern and is responsible for handling web requests.
In Grails a controller is a class with a name that ends in the convention "Controller" and lives in the grails-app/controllers directory.
Controllers:
    A controller handles requests and creates or prepares the response.
    A controller can generate the response directly or delegate to a view.
    To create a controller, simply create a class whose name ends with Controller in the grails-app/controllers directory



The real purpose of a controller is to deal with routing logic- which means: 
 - Receive requests from users
 - Invoke the most appropriate business logic
 - Invoke the view to display the result

View: logic should be taken care of inside Groovy Server Pages (GSP) files


Controller: It is a servlet which handles all the request from the front end.
In general, Grails servlet extends Spring’s DispatcherServlet to bootstrap the Grails environment 
*/  
grails create-controller book // Creating a controller at the location "grails-app/controllers/myapp/BookController.groovy"

/*
Controller actions:
    A controller can have multiple public action methods. each action is mapped to a URI
    The preffered approach is to use method (at the past it was made using closures)
    The benefits are:
    - Memory efficient.
    - Allow using of stateless controllers (singleton scope)
    - override actions
    - Methods can be intercepted with standard proxying mechanisms

    The controller has a default URI that maps to the root URI
    default action:
        - If there is only 1 action - it is the default action.
        - method with the name index() - is the default when there are multiple actions.
        - set the property of the relevant method to default
        static defaultAction = "list"
  
    Scope: hash-like objects where you can store variables.
    
        servletContext - Also known as application scope, this scope lets you share state across the entire web application. 
                         The servletContext is an instance of ServletContext
        session - allows associating state with a given user and typically uses cookies to associate a session with a client. 
                  The session object is an instance of HttpSession
        request - The request object allows the storage of objects for the current request only. 
                  The request object is an instance of HttpServletRequest
        params - Mutable map of incoming request query string or POST parameters
        flash - ...
*/
static scope = "singleton"

// Define default scope:
grails.controllers.defaultScope = "singleton"

/*
    All the controllers are placed in the dir: "grails-app/controllers/myapp/BookController.groovy"
    Creating a controller:
        1. class name includes Controller in the suffix. example: class SimpleController.
        2. define the package where the controller is defined.
        3. 
*/ 

//Controller Example:
package asia.grails.tutorial

class HelloController {
	def index() {              // returns to the browser in the index.gsp.
		render "Hello World"   // render = return result to the browser.
	}
	def hi() {                 // returns to the browser in the hi.gsp.
		render "How are you?"
	}
}


// .gsp - static HTML file.


// Spring
/*
The URL: 127.0.0.1:8080 

build.xml - this file builds the project when running it.
Spring provides pre-written servlet calls: Dispatcher Servlet.
Each controller has a plugin to the Dispatcher.

Browser  <--------> Server
Spring DispatcherServlet decides which controller will react to the request
The DispatcherServlet is the web-app.xml file.
<servlet>
    ...
</servlet>

<Servlet-mapping>
    all the url patterns are filled inside here.
</Servlet-mapping>

Controller -----> calls the relevant ---> Model (Spring service)  // it is done automatically without Application Context.
The Model runs and represents the result in the relevant .gsp page

Usually the controller returns a collection of data (list / map)
The collection is sent to the view and the Spring shows it.
@RequestMApping("/viewAllBooks") - This is a method we wants to connect it by the URL from the Browser.

@Controller - Marks the class as a controller.
Use it before the class signature.

@Autowired - searching for bean of the methodname in the beans file.

@RequestMapping("/viewAllBooks") - before the method

*/





// --------------  Grails Web Layers  -------------- //
/*
Controllers:
    A controller handles requests and creates or prepares the response.
    A controller can generate the response directly or delegate to a view.
    To create a controller, simply create a class whose name ends with Controller in the grails-app/controllers directory
*/  
grails create-controller book // Creating a controller at the location "grails-app/controllers/myapp/BookController.groovy"

/*
Controller actions:
    A controller can have multiple public action methods. each action is mapped to a URI
    The preffered approach is to use method (at the past it was made using closures)
    The benefits are:
    - Memory efficient.
    - Allow using of stateless controllers (singleton scope)
    - override actions
    - Methods can be intercepted with standard proxying mechanisms


    The controller has a default URI that maps to the root URI
    default action:
        - If there is only 1 action - it is the default action.
        - method with the name index - is the default when there are multiple actions.
        - set the property of the relevant method to default
        static defaultAction = "list"
  

    Scope: hash-like objects where you can store variables.
    
        servletContext - Also known as application scope, this scope lets you share state across the entire web application. 
                         The servletContext is an instance of ServletContext
        session - allows associating state with a given user and typically uses cookies to associate a session with a client. 
                  The session object is an instance of HttpSession
        request - The request object allows the storage of objects for the current request only. 
                  The request object is an instance of       HttpServletRequest
        params - Mutable map of incoming request query string or POST parameters
        flash - ...
*/
static scope = "singleton"

// Define default scope:
grails.controllers.defaultScope = "singleton"

/*
    Creating a controller:
        1. class name includes Controller in the suffix.
        2. define the package where the controller is defined.
        3. 
*/ 

//Controller Example:
package asia.grails.tutorial

class HelloController {
	def index() {              // returns to the browser in the index.gsp.
		render "Hello World"   // render = return result to the browser.
	}
	def hi() {                 // returns to the browser in the hi.gsp.
		render "How are you?"
	}
}

//The show action is used to display and individual resource by id
def show(Book book) {
    respond book
}
// The following code is equivalent to the above code.
def show(Book book) {
    if(book == null) {
        render status:404
    }
    else {
        return [book: book]
    }
}

// .gsp - static HTML file.



//The show action, which is used to display and individual resource by id.
def show(Book b) {
    respond b
}

def show(Book b) {
    if(b==null) {
        render status:404 // Renders the content that will be returned to the browser as the response body.
                          // render(options = nil, extra_options = {}, &block) protected
    }
    else {
        return[book: b]
    }
}


//The save action creates new resource representations
@Transactional
def save(Book book) { }

//The update action updates an existing resource representations and is largely similar to the save action.
@Transactional
def update(Book book) { }



// ------------ Grails - The Service Layer ------------ //
/*
Grails defines the notion of a service layer. 
The Grails team discourages the embedding of core application logic inside controllers, as it does not promote reuse and a clean separation of concerns.
Services in Grails are the place to put the majority of the logic in your application, leaving controllers responsible for handling request flow with redirects and so on.

*/

// Creating a service:
grails create-service helloworld.simple // Creating a service in 'grails-app/services/helloworld/SimpleService.groovy'
// A service's name ends with the convention Service, other than that a service is a plain Groovy class.

domain-class <-->  Services // coordinating logic.
// Frequently require transactional behaviour.
// All services are transactional by default. It may be changed by setting the transactional property to false
class CountryService {
    static transactional = false
}

//------------------------------------------------------//
/*    Important
dependency injection is the only way that declarative transactions work. 
You will not get a transactional service if you use the new operator such as new BookService()
In practice: Creating Controller and in the C'tor signature we referencing to the relevant service and inject it when creating the controller.
*/
//------------------------------------------------------//

// Grails also provides @Transactional and @NotTransactional annotations for cases where you need more fine-grained control over transactions.
// at a per-method level or need to specify an alternative propagation level. it enables mixing betweent the Class and the methods:
// For example, the @NotTransactional annotation can be used to mark a particular method to be skipped when a class is annotated with @Transactional.


