// -----------------  Model and View  ----------------- //
// Model - is a Map that the view uses when rendering.
// Returning a model by explicitly return a Map instance: 
def show() {
    [book: Book.get(params.id)]
}
// A more advanced approach is to return an instance of the Spring ModelAndView class:
import org.springframework.web.servlet.ModelAndView

def index() {
    // get some books just for the index page, perhaps your favorites
    def favoriteBooks = ...
    // forward to the list view to show them
    return new ModelAndView("/book/list", [ bookList : favoriteBooks ])
}

/* 
certain variable names can not be used in your model:
    - attributes
    - application
*/

// Grails will look for a view at the location grails-app/views/book/show.gsp for this show action
// Rendering a response (using a render keyword
// rendering specific GSP (if you are reusing the same GSP for different actions)
package asia.grails.tutorial
class HelloController {
	def index() { 
	}
	def hi() {
		render (view:'index.gsp') // this is the view that is returned.
	}
}


// Redirect  controller method (internally uses the HttpServletResponse Object's sendRedirect method)
// redirect expects toone of the followings :
//    - A closure within the same class
//    - The name of an action (and controller name if the redirect isn't to an action in the current controller)
//    - A URI for a resource relative the application context path:
//    - A full URL
redirect(url: "http://grails.org")

redirect(action: 'login')


//grails-app/views directory 
render(view: "index")
/*
A GSP typically has a "model" which is a set of variables that are used for view rendering. 
The model is passed to the GSP view from a controller

GSP supports the usage of <% %> scriptlet blocks to embed Groovy code
use the <%= %> syntax to output values

g: it is automatically assumed to be a GSP tag


*/
