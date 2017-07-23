
### DB
-----

Links:
https://docs.mongodb.com/manual/reference/database-references/



A basic rule of thumb is to use a DBRef if the value of a key is a document is in a different collection.

Not all the drivers support DBRef, check the 
DBRef constructor for your driver takes a third argument:


cons:

When the project gros it would be difficult to manage data linked with DBRef.
Cannot clean / update data.


The better chiose is:

    package_id:"dfdsdfa"
