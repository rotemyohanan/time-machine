Hibernate sessions:

Hibernate is a session-based ORM framework.
session: is basically an **in-memory cache** of objects that are backed by a database.

save a new domain instance, it is implicitly attached to the session, it is added to the cache and becomes a Hibernate-managed object. But it may not be persisted to the database at that point! 


Save:

    book.save(flush: true)
**flush**: true forces Hibernate to persist all changes to the database right away



Hibernate supports the concept of dirty-checking
