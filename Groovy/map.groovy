


// -------------------      Map / Directory (associative array)    -------------------- //
// Default Map creation is a LinkedHashMap
// The (':') defines the object as a Map and not as list.
// Permits null
def map = [:]
map.'name'
// The LinkedHashMap is not synchronized (It can be wrapped by Collections.synchronizedMap method)
Map m = Collections.synchronizedMap(new LinkedHashMap(...));
// fails fast iterator - hence there is no ability to change the structure of the map during iterating over its.
// Fail-fast iterators throw ConcurrentModificationException on a best-effort basis.
def map = [name: 'Rotem', likes: 'Meat', id: 'Reading books']
assert map.get('name') == 'Rotem';
assert map.name == 'Rotem'; // Equivalent to the get() method.
// The same happens in the set methods.
map.remove('keyName');
def emptyMap = [:]
emptyMap.put("foo", 5) // Map key value types are by default String [a:1] equivalent to ['a':1]
//When There is a variable with the name 'a' then we need to escape the key by adding ()
ages = [(a):34] 
// When key not exists, null is returned.

//iterate on map entries, it is guaranteed that the entries will be returned in the same order they were added in the map
// Means that there is no ordering of the map entries by default.

// Iterating
map.each { entry ->
	println "Name: $entry.key Age: $entry.value"
}

map.eachWithIndex {
	entry , i ->
			println "$entry.value";
}

// Reading values from the map
${map['keyName']}

// Default value returns by the map:
//                                                     Default value    
assert 'Red' == [color:'Red', shape:'blue'].get('color', 'Blue') // The color exists in the map.
//                                          Default value
assert 'Blue' == [shape:'blue'].get('color', 'Blue') // The color is not a key in the map.

// Get all the keys as a Set
${map1.keySet()}
// Get all the values
${map1.values()}

// Sorting the Map
map.sort() // equivalent to the map.sort{ it.value }, hence the order by the "ABC" order.
map.sort{-it.value} // Sorting by descending values
// Clear the map
map.clear()

def entries = map.entrySet()

// Grouping - Group the map into list using .groupBy()
// Groovy has GPath, a path expression language to navigate in XML or POJOs

Reading from Map.grouping
