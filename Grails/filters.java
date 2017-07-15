// -------------------- Filter ----------------------- //

grails-app/conf

class ExampleFilters {
   def filters = {
        // your filters here
   }
}

The scope of the filter can be one of the following things:
A controller and/or action name pairing with optional wildcards
A URI, with Ant path matching syntax

To control the order of execution between Filters classes, you can use the dependsOn property discussed in filter dependencies section

Filter Types:
Within the body of the filter you can define one or several of the following interceptor types for the filter:
before - Executed before the action. 
after - Executed after an action. 
afterView - Executed after view rendering.
    
class SecurityFilters {
   def filters = {
       loginCheck(controller: '*', action: '*') {
           before = {
              if (!session.user && !actionName.equals('login')) {
                  redirect(action: 'login')
                  return false
               }
           }
       }
   }
}

dependesOn:

class MyFilters {
    def dependsOn = [MyOtherFilters]
    def filters = {
        checkAwesome(uri: "/*") {
            before = {
                if (request.isAwesome) { // do something awesome }
            }
        }

        checkAwesome2(uri: "/*") {
            before = {
                if (request.isAwesome) { // do something else awesome }
            }
        }
    }
}
