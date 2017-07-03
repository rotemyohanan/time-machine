

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
    db.repoElement.update({'_id':'5948e61805166a7cb5f56e4d'}, {$set: { version : 3 }})
    
find the document with id == '5948e61805166a7cb5f56e4d'.
If the field version exists: set its value to 3.
If not: create new field calls version and set its value to 3.


    

