Hibernate sessions:

Hibernate is a session-based ORM framework.

###### session: 
It is basically an **in-memory cache** of objects that are backed by a database.

save a new domain instance, it is implicitly attached to the session, it is added to the cache and becomes a Hibernate-managed object. But it may not be persisted to the database at that point! 


Save:

    book.save(flush: true)
**flush**: true forces Hibernate to persist all changes to the database right away



Saving when I don't want to:

Hibernate supports the concept of dirty-checking, What this means is that Hibernate checks whether any values of a domain instance’s (persistent) properties have changed after that instance has been pulled from the database, and will persist those changes to the database.
Let’s say we have a Book domain class with title and author properties, and the following code is in a controller action:





all the properties are persistent unless configured as transient.
Changing any property value by the time the session closed, cause to the property be changed in the DB.

How do objects become attached?

Using GORM to retrieve a domain instance cause to the object be automatically associated with the session.

If you just create a new instance via the new keyword, then the object is not attached to the session until the save() method is called.

domain class properties are persistent by default.
You can make properties transient by adding their names to the static transients list property, which means that their values aren’t stored in the database.

 //TODO add the code describe that.
 
 Session open / closed
 
 after closing the access to the DB is no longer enabled
 Before closing the session the data is flushed to the DB.

 Hibernate session affects persistence of domain instances.
 
#### Actions:
----
- call the save() method:
   
    > save(failOnError: true)
     
- check the return value of the save method.
 
