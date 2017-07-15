//GORM is Grails' object relational mapping (ORM) Implementation. 
//Under the hood it uses Hibernate 3 (a very popular and flexible open source ORM solution)
// Easy working with database

object-mapping layer on top of Mongo

/*
Main issues:
  - Marshalling from Mongo to Groovy/Java types and back again.
  - Support for GORM dynamic finders, criteria and named queries
  - Session-managed transactions
  - Validating domain instances backed by mongo datastore

'interaction/webapp/grails-app/conf/'

 The original GORM for MongoDB converted MongoDB documents to and from Groovy objects. This engine is still present and can be activated with the following configuration in grails-app/conf/application.yml:

*/
//create domain-class
grails create-domain-class helloworld.Person // create a class at the location "grails-app/domain/helloworld/Person.groovy" 
    
grails console // Once you have a domain class try and manipulate it with the shell or console 
// This loads an interactive GUI where you can run Groovy commands with access to the Spring ApplicationContext, GORM, etc.

// Basic CRUD (Create/Read/Update/Delete) operations.
// Create
def p = new Person(name: "Fred", age: 40, lastVisit: new Date())
p.save()
// Read
def p = Person.get(1) // 1 - database identifier.
assert 1 == p.id
// Read - command
def p = Person.read(1) // 
// Load a proxy for an instance.
def p = Person.load(1)
// Update, means changing of some properties.
def p = Person.get(1) // Read  1 is the database identifier to read the person.
p.name = "Bob"
p.save()
// Delete
def p = Person.get(1)
p.delete()

// Creation of a class will map automatically to a table in the database.
/*
Domain classes are core to any business application.
They hold state about business processes and hopefully also implement behavior.
They are linked together through relationship.

*/


// Creating domain class
grails create-domain-class helloworld.Person // create a class at the location grails-app/domain/helloworld/Person.groovy 

//6.4.1 Dynamic Finders
/*
A dynamic finder looks like a static method invocation, but the methods themselves don't actually exist in any form at the code level.
Instead, a method is auto-magically generated using code synthesis at runtime, based on the properties of a given class. Take for example the Book class
*/

class Book {
    String title
    Date releaseDate
    Author author
}

class Author {
    String name
}

//The Book class has properties such as title, releaseDate and author. 
//These can be used by the findBy and findAllBy methods in the form of "method expressions": (dynamic finders)
def book = Book.findByTitle("The Stand")
book = Book.findByTitleLike("Harry Pot%")
book = Book.findByReleaseDateBetween(firstDate, secondDate)
book = Book.findByReleaseDateGreaterThan(someDate)
book = Book.findByTitleLikeOrReleaseDateLessThan("%Something%", someDate)

//Method Expressions
/*
A method expression in GORM is made up of the prefix such as findBy followed by an expression that combines one or more properties. The basic form is:
*/
Book.findBy([Property][Comparator][Boolean Operator])?[Property][Comparator]

/*
The possible comparators include:

InList - In the list of given values
LessThan - less than a given value
LessThanEquals - less than or equal a give value
GreaterThan - greater than a given value
GreaterThanEquals - greater than or equal a given value
Like - Equivalent to a SQL like expression
Ilike - Similar to a Like, except case insensitive
NotEqual - Negates equality
InRange - Between the from and to values of a Groovy Range
Rlike - Performs a Regexp LIKE in MySQL or Oracle otherwise falls back to Like
Between - Between two values (requires two arguments)
IsNotNull - Not a null value (doesn't take an argument)
IsNull - Is a null value (doesn't take an argument)

*/


// Querying Associations: Associations can also be used within queries:

//6.4.4 Detached Criteria
/*
Detached Criteria are criteria queries that are not associated with any given database session/connection.
Detached Criteria queries have many uses including allowing you to create common reusable criteria queries, execute subqueries and execute batch updates/deletes.

Building Detached Criteria Queries:
The primary point of entry for using the Detached Criteria is the grails.gorm.DetachedCriteria class which accepts a domain class as the only argument to its constructor
*/
def criteria = new DetachedCriteria(Person)
//Once you have obtained a reference to a detached criteria instance you can execute where queries or criteria queries to build up the appropriate query.
// Building normal DetachedCriteria
def criteria = new DetachedCriteria(Person).build {
    eq 'lastName', 'Simpson'
}

Refersh() - load the object again from the database, all the changes in the object are reverted.

/*
ORM - 
Relational database is still the most popular way to store and retrieve information because the technology is very mature and it has many software options
ORM frameworks objective is to present an API where you can just think and program in objects, and the underlying framework will handle how to interface with the relational database. 


*/
    
Gorm - mapping:
    
    properties:
    hasMany = [members: User]
    belongsTo = User  // This is the ownership of the relationship - effect the save and delete of that object.
        // The hirarchy is 'owner' and 'dependant'
class Book {
    
    String title
    static BelongsTo = [Author: author]
}

    // relationship type: 
        Many-to-one
        One-to-many
    constraints = {
        owner nullable: false
        /*
            username regex:
                start with a letter or a digit,
                         followed by a sequence of letters, digits and dashes,
                         where there are no two consecutive special characters
                end with a letter or a digit
        */
        username unique: true, blank: false, nullable: false, size: 2..63, matches: '(([a-zA-Z\\d]{1})([[a-zA-Z\\d] | [\\-]]?[a-zA-Z\\d]+)+)', validator: {
            val, obj, errors ->
                constraintUsernameReserved(val, errors)
                constraintUsernameUnique(val, obj, User.findByUsername(val.toLowerCase()), errors)
                constraintUsernameForbiddenParts(val, obj, errors)
        }
        email nullable: true, blank: false, unique: true, matches: '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+'
        showEmailAddress nullable: true
        hiddenMembersIds nullable: true
        defaultHiddenMembership nullable: true
    }







//  ----------------------  Object Relational Mapping  -------------------------- //
/*
Domain classes are core to any business application.

A domain class fulfills the M in the Model View Controller (MVC) pattern 
It represents a persistent entity that is mapped onto an underlying database table.
In Grails a domain is a class that lives in the 'grails-app/domain' directory.
*/

// Creating domain class
grails create-domain-class org.bookstore.Book
    
/*    
The class name, by default, is mapped to the table name in lower case and separated by underscores 
instead of camel case so a domain class named BookStore by default would map to a table named book_store. 
Each property maps to individual columns
*/

/*
Emphasizes:
    1. Don't give the same name to classes (even if they are in different packages) cause the mapping will be into the same table in the DB.

*/


// Dynamic finders:
/*
    
*/
