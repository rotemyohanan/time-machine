

### Many-To-One

#### A transient instance

A transient instance is one that isn’t attached to a Hibernate session.

Means that the object should be saved in the DB before making the relationship connection.


Many-to-one properties must have persistent instances as values.
It’s because domain classes usually use the belongsTo property in situations like this.

### Cascading with belongsTo

Most common actions connected with cascading: SAVE / DELETE.


### BelongsTo 

    
    static belongsTo = Author

The belongsTo line ensures that saves/deletes are cascaded from Author to its owner domain.

Delete the owner Domain also delete the related Domain.
Saving/Deleting the sub Domain does not delete the owner Domain.

https://spring.io/blog/2010/07/02/gorm-gotchas-part-2/
