// ---------- Grails Domains ---------- //

autoTimeStamp:
By default when you have properties called dateCreated and/or lastUpdated in a domain class, Grails automatically maintains their state in the database.

// Stoppong the auto time stamp
static mapping = {
    autoTimestamp false
}

Conclusion:
Grails integrates with Spring's event mechanism and provides the AbstractPersistenceEventListener base class to listen to certain GORM events. Grails uses this mechanism internally for example for the GORM event hooks but it can of course be used by the application logic too. This article showed how to introduce support for userCreated and userUpdated which are similar to dateCreated and lastUpdated but store the principal how created, updated or deleted a domain object

AbstractPersistenceEventListener   -->  DomainEventListener

DomainEventListener is responsible for executing the GORM event hooks on domain object inserts, updates and deletes.
The event listener is registered at the application context as the PersistenceListener interface (which is implemented by AbstractPersistenceListener) extends from Spring's ApplicationListener and therefore actually uses the Spring event system.
    
    In order to create a custom persistence listener, we just have to extend AbstractPersistenceEventListener and listen for the GORM events which are useful to us. Here is the implementation we ended up with:
