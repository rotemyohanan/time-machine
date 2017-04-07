//using java-script in the mongo shell

var glbal = db.getCollection('binaryObject').find({});
glbal.forEach( function(it){ print(it.name) });

var glbal = db.getCollection('binaryObject').find({}).forEach(function(binary){
    var bin =  binary.name;
    print("name " + bin);
});
