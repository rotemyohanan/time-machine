//using java-script in the mongo shell
// ---------------------------------------------------------------------------------------------------
//  Simple examples
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
       keys.push({"doc.id": doc._id, "key":key, "value":doc[key]});
      }
    }
});
print(keys);   // prints all the results

// ---------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------
