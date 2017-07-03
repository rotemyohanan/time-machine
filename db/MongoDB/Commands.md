

### MongoDb commands
-----

##### Simple commands:
----

    db.collection.find({'name':'artifactName'}) 


##### RegExp:
----

    db.collection.find({'path.element':{ $regex : /org\/repo\/artifactName/} })

#####  Update:
-----
    db.collection.update({'_id':'5948e61805166a7cb5f56e4d'}, {$set: { version : 3 }})
    
find the document with id == '5948e61805166a7cb5f56e4d'.
If the field version exists: set its value to 3.
If not: create new field calls version and set its value to 3.


    
##### $push:
-----
**Relevant only to Arrays.**

Array Field (json example):       
    
    "names" : [ "org", "jfrog", "test"]

The $push operator appends a specified value to an array.

    { $push: { <field1>: <value1>, ... } }
    
If the field is absent in the document to update?    
$push adds the array field with the value as its element.

o add each element of the value separately, use the $each modifier with $push.

**$each** Appends multiple values to the array field.



