//using java-script in the mongo shell

// Simple examples

var glbal = db.getCollection('binaryObject').find({}).forEach(function(binary){
    var bin =  binary.name;
    print("name " + bin);
});
