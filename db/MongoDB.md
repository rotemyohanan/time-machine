  
# MongoDB

short
Running the server.
Create dir where all the data files are stoered into.  
> ‘\data\db’
 
Port: 27017 (default)
 
**Mongod** : is the command in the shell.  (Mongo deamon)

 
#### Atomicity and Transactions:
----

In MongoDB, a write operation is atomic on the level of a **single document**. 
(even if the operation modifies multiple embedded documents within a single document)
When a single write operation modifies multiple documents, the modification of each document is atomic, but the operation as a whole is not atomic and other operations may interleave.

There is an ability to isolate a single write operation that affects multiple documents using the **$isolated** operator.
**$isolated** prevent other processes from interleaving once the write operation modifies the first document.
This ensures that no client sees the changes until the write operation completes or errors out.

 > Note:   
 > $isolated does not work with sharded clusters.
 > An isolated write operation does not provide “all-or-nothing” atomicity. That is, an error during the write operation does not roll back all its changes that preceded the error.


Concurency control:

1. unique index (on a field that can only have unique values). 
This prevents insertions or updates from creating duplicate data. 


#### Two phase commit:

Multi-document updates or “multi-document transactions” 
Writing data to multiple documents. This process can be extended to provide a rollback-like functionality.

----
Operations on a single document are always atomic with MongoDB databases.
Operations that involve multiple documents, “multi-document transactions”, are not atomic.
----

**Atomicity:** if one operation fails, the previous operation within the transaction must “rollback” to the previous state (i.e. the “nothing,” in “all or nothing”).
**Consistency:** if a major failure (i.e. network, hardware) interrupts the transaction, the database must be able to recover a consistent state.

##### Concept of 2 phase commit:

Using two-phase commit ensures that data is consistent and, in case of an error, the state that preceded the transaction is recoverable. During the procedure, however, documents can represent pending data and states.








/* 
All queries in mongoDB have the scope of a single collection.
Query - returns all the documents in a collection / filterd documents that passed the filter. 
Write operations are atomic on the level of a single document, even if the operation modifies multiple embedded documents within a single document.
When a single write operation modifies multiple documents, the modification of each document is atomic, but the operation as a whole is not atomic and other operations may interleave.
$isolated operator - isolate a single write operation that affects multiple documents.
*/
mongod instance running on localhost on port number 27017
// Import data into the collection
mongoimport --db test --collection resturants --drop --file primer-dataset.json
// help 
help
// Creating database / change to exists database / switch to existing database 
use <db-name>
// Insert Document - [WriteResult]
// Each insertion creates automatic "_id" to the document if there is no existing one.
db.resturants.insert(
 {
  "address" : {
    "street"  : "2 Avenue",
    "zipcode" : "10075"
  },
     "brought" : "Manhattan"
 }
)

// Find() - retrieve all the data from a collection
db.resturants.find() // Returns all the documents in the resturants collection.
db.resturants.findOne() // returns the first document according to the natural order which reflects the order of documents on the disk
// Filter:
db.resturants.find({ "borough": "Manhattan" }) // find the documents which their field "borough" == "Manhattan"
/* 
    $gt - greater than.
    $lt - less than.
    
*/
db.restaurants.find( { "grades.score": { $gt: 30 } } )
// OR $or
db.restaurants.find(
   { $or: [ { "cuisine": "Italian" }, { "address.zipcode": "10075" } ] }
)
// .sort() query result
db.restaurants.find().sort( { "borough": 1, "address.zipcode": 1 } ) // The sorting order is defined by the fields order inside the {}

// update() - update documents of a collection - by default udpates single document. 
// Returning Object: WriteResult(contains the status of the operation).
// update() cannot update the "_id" field.
db.restaurants.update(
    { "name" : "Juni" },  // This is the document which is updated.
    {
      $set: { "cuisine": "American (New)" }, // sets the value for the field "cuisine"
      $currentDate: { "lastModified": true }
    }
)

// update multiple documents, by addition of {multi: true}
db.restaurants.update(
  { "address.zipcode": "10016", cuisine: "Other" },
  {
    $set: { cuisine: "Category To Be Determined" },
    $currentDate: { "lastModified": true }
  },
  { multi: true}
)


https://css-tricks.com/couple-takes-sticky-footer/
// Replace a document - if the "_id" is not in the update section then the mongoDB creates new "_id"
/* .remove()  - removing a data.  By default removes all documents that match the remove condition.
    Returns a WriteResult object which contains the status of the operation.  
    nRemoved field specifies the number of documents removed
*/
db.restaurants.remove( { "borough": "Manhattan" } )  // removes all documents that match the specified condition.
// justOne Option limits the remove operation to only one of the matching document.
db.restaurants.remove( { "borough": "Queens" }, { justOne: true } )

// Remove all the documents in the collection. It will be more efficient to drop the entire collection.
db.restaurants.remove( { } )
====================================================================
// Drop collection
// .drop()
// Returns true / false (depending on the success)
db.restaurants.drop()
====================================================================
// Find in array
array of 'values' = ['liora'] in each customAttribute document.
db.customAttribute.find({ values : { $in : ['liora'] }})
====================================================================

// Aggregation:
Aggregation operations group values from multiple documents together, and can perform a variety of operations on the grouped data to return a single result.
    
db.customAttribute.find({}).limit(5)// returns only the 5 first results.
db.customAttribute.find({}).skip(2)// skip the first 2 results.
db.customAttribute.find({}).sort({KEY: 1}) // sort using a list of field along with their sorting order.
//specifying the order using 1 = ascending / -1 = decending
    
db.customAttribute.aggregate({ $match: {type: 'STRING'} }, {$match: {refElementClass: 'User'}}, { $limit : 4} )
    
// Aggregation operation. a stage-based aggregation. the method accepts an array of stages. 
// Each stage processed sequentially, describes a data processing step.
db.collection.aggregate( [ <stage1>, <stage2>, ... ] )
// Use the $group stage to group by a specified key.
db.restaurants.aggregate(
   [
       //        The grouping key.
     { $group: { "_id": "$borough", "count": { $sum: 1 } } }
   ]
);
//  $match  - stage to filter documents.
//  $sum  - accumulator to calculate the count.
db.restaurants.aggregate(
   [
     { $match: { "borough": "Queens", "cuisine": "Brazilian" } },
     { $group: { "_id": "$address.zipcode" , "count": { $sum: 1 } } }
   ]
);

// Indexes can support the efficient execution of queries
// MongoDB automatically creates an index on the _id field upon the creation of a collection.
// createIndex() method to create an index on a collection if the idnex does not exists.
db.restaurants.createIndex( { "cuisine": 1 } )
// Returns a document with the status of the operation.
// The return status
{
  "createdCollectionAutomatically" : false,
  "numIndexesBefore" : 1,
  "numIndexesAfter" : 2, // in success the index number after is one greater than the numIndexBefore.
  "ok" : 1
}

// Creating a compound index (indexes on multiple fields):
// The order of the fields determine how the index stores its keys
db.restaurants.createIndex( { "cuisine": 1, "address.zipcode": -1 } )

// Concurrency:
/* 
$isolated operator, a write operation that affects multiple documents can prevent other processes from interleaving 
once the write operation modifies the first document.
This ensures that no client sees the changes until the write operation completes or errors out.
$isolated does not work with sharded clusters.
An isolated write operation does not provide “all-or-nothing” atomicity. 
*/

/* Indexes: support the efficient execution of queries in MongoDB
Indexes are special data structures which store a small portion of the collection’s data, 
set in an easy to traverse form.
Default: "_id"  this is the ObjectId. (created by the mongod)

Indexes (Special data structure) provide high performance read operations for frequently used queries.
without an index performing a collection search.(which is slow)
if the index exists - then it limits the number of documents the query inspects.
MongoDB can return sorted results by using the ordering in the index.
MongoDB indexes use a B-tree data structure.
*/

// ---- upload the MongoDB in the localhost --- //
// 1. open interactive command prompt and enter:
//Running the mongo
mongo --host bt-local
//Default port mongo 27017

//'bt_read' - database production with READ ONLY permissions

/////////////////////////////////////////////////////////////////////
//              Define MongoDB in RoboMongo
/////////////////////////////////////////////////////////////////////
// Name: any name I want

// databases:
bt_production
audit_production

// Auth Mechanism: 
MONGODB-CR

//Address
108.168.243.147 - Primary
108.168.243.146 - Secondary

// Hosting to any other sites by removing the '.com' suffix
mongo1-ams-stg.bintray(.com)
//port number
27017


