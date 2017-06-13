

### MongoDb commands
-----

##### Simple commands:
----

    db.collection.find({'name':'artifactName'}) 


##### RegExp:
----

    db.collection.find({'path.element':{ $regex : /org\/repo\/artifactName/} })


