

Groovy:
=======
int value = "99".toInteger()

Grails:
=======
Grails Controller:
Integer intValue = params.int('99')

def save() {
    def show() {
        def book = new Book(params)
    }
}

The standard Servlet API provides access to parameters with 'HttpServletRequet' Object

Grails 8.1.5
============
    
DataBinding:
Data binding is the act of "binding" incoming request parameters onto the properties of an object or an entire graph of objects
