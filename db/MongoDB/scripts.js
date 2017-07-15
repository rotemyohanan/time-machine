
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
    
    
    
    
// Using JS in the mongo shell

var glbal = db.getCollection('binaryObject').find({})
glbal.forEach( function(it){ print(it.name)})

var glbal = db.getCollection('binaryObject').find({}).forEach(function(binary){
    var bin =  binary.name
    print("name " + bin)
}) 


db.getCollection('customAttribute').find({'_id':'58286b5764cbe521e24b78e8'}).forEach(function(obj) { print(obj.name)})


///  Sum all the BinaryObjects bytes  ///
 var sizeSum = 0;
db.binaryObject.find({}).forEach(function(bo){
    sizeSum+=bo.size;
    })
    print(sizeSum)
///
    
All Binary Objects result = 529456595 Bytes ~ 0.529 GB

All the BintrayBtn:

count = 248114 [Number of BintrayBtn]
Sum = 177697547 [Bytes]
Average size of BintrayBtn = 716.193 [Bytes].
////////////////////////////
var sum = 0;
var count = 0;
db.getCollection('binaryObject').find({'_class':'BintrayBtn'}).forEach(function(bo){
    sum+=bo.size;
    })
print(sum)
/////////////////////////
    


"absolute_path":"/teralytics/internal-docker/teralytics/hyperloop-dashboard/_uploads/fefb7101-2d66-469f-9c09-249e1b78ab58" op_name":"artifact.syncreaders"

============================================================================
var names = db.team.find({'owner.$id': '58dbd69dd601801775329526'}).toArray();
   
var uniq = names
.map((name) => {
  return {count: 1, name: name}
})
.reduce((a, b) => {
  a[b.name] = (a[b.name] || 0) + b.count
  return a
}, {})

var duplicates = Object.keys(uniq).filter((a) => uniq[a] > 1)


==================================================================================
