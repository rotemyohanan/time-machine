
// Using javascruot in the mongo shell

var glbal = db.getCollection('binaryObject').find({})
glbal.forEach( function(it){ print(it.name)})

var glbal = db.getCollection('binaryObject').find({}).forEach(function(binary){
    var bin =  binary.name
    print("name " + bin)
}) 


db.getCollection('customAttr').find({'_id':'58286b5764cbe521e24b76e8'}).forEach(function(obj) { print(obj.name)})


///  Sum all the BinaryObjects bytes  ///
 var sizeSum = 0;
db.binaryObject.find({}).forEach(function(bo){
    sizeSum+=bo.size;
    })
    print(sizeSum)
///
    

============================================================================
var names = db.team.find({'owner.$id': '58dbd49dd601803775329526'}).toArray();
   
var uniq = names.map((name) => {
  return {count: 1, name: name}
}).reduce((a, b) => {
  a[b.name] = (a[b.name] || 0) + b.count
  return a
}, {})

var duplicates = Object.keys(uniq).filter((a) => uniq[a] > 1)

==================================================================================
