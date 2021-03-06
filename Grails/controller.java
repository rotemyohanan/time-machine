

// ---------------   render   --------------- ///
A multi-purpose method for rendering responses to the client which is best illustrated with a few examplesץ

Warning!!! - this method does not always support multiple parameters. 
For example, if you specify both collection and model, the model parameter will be ignored.

render (view: 'index', 
        model:[projectList: list, count: number])

model: is a map.
view: simliar to the GSP multiple domains. - it is a method. 
    
    
 // renders text to response
render "some text"

// renders text for a specified content-type/encoding
render(text: "<xml>some xml</xml>", contentType: "text/xml", encoding: "UTF-8")

// render a template to the response for the specified model
def theShining = new Book(title: 'The Shining', author: 'Stephen King')
render(template: "book", model: [book: theShining])

// render each item in the collection using the specified template
render(template: "book", collection: [b1, b2, b3])

// render a template to the response for the specified bean
def theShining = new Book(title: 'The Shining', author: 'Stephen King')
render(template: "book", bean: theShining)

// render the view with the specified model
def theShining = new Book(title: 'The Shining', author: 'Stephen King')
render(view: "viewName", model: [book: theShining])

// render the view with the controller as the model
render(view: "viewName")

// render some markup to the response
render {
    div(id: "myDiv", "some text inside the div")
}

// render some XML markup to the response
render(contentType: "text/xml") {
    books {
         for (b in books) {
             book(title: b.title, author: b.author)
         }
    }
}

// render a JSON ( http://www.json.org ) response with the builder attribute:
render(contentType: "application/json") {
    book(title: b.title, author: b.author)
}

// render with status code
render(status: 503, text: 'Failed to update book ${b.id}')

// Automatic marshalling of XML and JSON
import grails.converters.*
...
render Book.list(params) as JSON
render Book.get(params.id) as XML

// render a file
render(file: new File(absolutePath), fileName: "book.pdf")   

    
Parameters:

text (optional) - The text to render

builder (optional) - The builder to use when rendering markup

view (optional) - The view to delegate the rendering to

template (optional) - The template to render. A template is usually an HTML snippet and the file starts with an underscore ("_"). This is used mostly in AJAX requests.

layout (optional) - The layout to use for the response

var (optional) - The name of the variable to be passed into a template, defaults to the Groovy default argument 'it' if not specified

bean (optional) - The bean to use in rendering

model (optional) - The model to use in rendering

collection (optional) - For rendering a template against each item in a collection

contentType (optional) - The contentType of the response

encoding (optional) - The encoding of the response

converter (as single non-named first parameter) - A Converter that should be rendered as Response

plugin (optional) - The plugin to look for the template in

status (optional) - The HTTP status code to use

file (optional) - The byte[], java.io.File, or inputStream you wish to send with the response

fileName (optional) - For specifying an attachment file name while rendering a file.
