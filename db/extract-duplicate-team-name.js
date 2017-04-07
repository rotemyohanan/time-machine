
var teams = db.team.find({'owner.$id': '58dbd69dd601801775329526'});

var teamsNames = teams.toArray().map(function (team){
    return team.name;
});

var teamMap = teamsNames.map(function (name) {
  return {count: 1, name: name}
}).reduce(function(a, b) {
  a[b.name] = (a[b.name] || 0) + b.count
  return a
}, {});

var result = []
for(var key in teamMap) {
    var value = teamMap[key];
    if(value > 1) {
        result.push(key)
    }
}
print(result);

====================================================================================================
// ----------------------------------
//   Alternative:  MongoDB query
// ----------------------------------

db.team.group({
     key: { "path": 1},
     reduce: function( curr, result ) { result.total += 1; },
     initial: { total : 0 }
}).forEach(function(e){ if(e.total > 1) { print(e.path) } })
