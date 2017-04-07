//using java-script in the mongo shell
// ---------------------------------------------------------------------------------------------------
//  Simple examples:
// ---------------------------------------------------------------------------------------------------
var glbal = db.getCollection('binaryObject').find({}).forEach(function(binary){
    var bin =  binary.name;
    print("name " + bin);
});

// ---------------------------------------------------------------------------------------------------
//  Iterate all the key value in documents, and run a query on each value.
// ---------------------------------------------------------------------------------------------------
var keys = [];

db.doors.find({}).forEach(function(doc){
    for (var key in doc){ 
      if(typeof(doc[key]) == 'number' && doc[key] > 20000){
       keys.push({"doc.id": doc._id, "key":key, "value":doc[key]}); // insert {} to add object into the list.
      }
    }
});
print(keys);   // prints all the results

// ---------------------------------------------------------------------------------------------------
//  Extract all the keys from a document.
// ---------------------------------------------------------------------------------------------------

var keys = [];
db.repoElement.find({'_id':'58b2beb3f026c13e30d0f564'}).forEach(function(doc){
    for (var key in doc){ 
           keys.push(key);
    }
});

print(keys);
