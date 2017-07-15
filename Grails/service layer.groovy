
/*

MVC pattern is a software architecture that encourages separation of concerns.

Model - handles data representation and operations.
For example:
Person and PersonService are part of the Model.


View - handles how data is viewed by the user. For example, the HTML.

Controller - handle the code that links a user to the system. It receives request or events from the user, prepare data and invoke proper business logic, and then return the view that represents the result of user actions.


Service Layer:
business logic, should be implemented inside the service layer.
    
Grails has a default support and handling for the service   
layer. 
    
    
// Don't Repeast Yourself (DRY) Principle
Having a single copy of a particular business logic will make a project shorter
 */

// Code
grails create-service <service-name>
    
// MVC

// Model  
// Domain class fulfills the M in the MVC pattern
// Domain class lives in the grails-app/domain dir
class Customer {
    String firstName, lastName
    Date birthday
    String gender
    String maritalStatus
}

// View : list.gsp
<table>
    <tr><th>Name</th><th>Gender</th></tr>
    <g:each in="${customerList}" var="cust">
        <tr><td>${cust.lastName}, ${cust.firstName}</td><td>${cust.gender}</td></tr>
    </g:each>
</table>

// Controller
class CustomerController {
    def list() {
        def list = Customer.list()
        [raw][list:list][/raw]
    }
}
                         
// The controller is invoked whenever the URI '/customer/list' is invoked 
    

    
Transaction:
"all or nothing behaviour" - atomicity concept.

Since Grails supports transactions, it automatically do these things to us when we declare a service to be transactional:
    - If all db operations are successful, reflect the changes to the database (this is also called commit)
    - If one db operation result in exception, return to the original state and forget/undo all the previous operations (this is also called rollback)

//Transaction Declaration 
//Grails supports transaction management inside services. By default, all services are transactional. So these 3 declarations have the same effect. 
class CountryService {
}

class CountryService {
    static transactional = true
}

@Transactional
class CountryService {
}

//How To Force A Rollback 
/*
One of the most important thing to remember is what code to write to force Grails to rollback a current succession of operations. To do that, just raise a RuntimeException or a descendant of it.

note: Exception in general will not force the roll back

*/
    
class AccountService {
  def transferFunds(long accountFromID, long accountToID, long amount) {
    Account accountFrom = Account.get(accountFromID)
    Account accountTo = Account.get(accountToID)
    accountFrom.balance = accountFrom.balance - amount
    throw new RuntimeException("testing only")
    accountTo.balance = accountTo.balance + amount
  }
}


    
//Model: Model is a Java object which stores the data that can be used by the controllers and views 
    

//PATCH vs PUT
PUT must take a full new resource representation as the request entity. 
PATCH updates a resource (not replacing the entire resource.)

Filter - grails plugin
