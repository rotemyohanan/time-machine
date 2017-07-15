

// -------------------    List   -------------------- //
// The default groovy list is an ArrayList
// Creating a list - By default it creates ArrayList
 def list1 = ['a','b','c','d','e','f','g','h'] 

LinkedList ll = new LinkedList<String>(["AA" BB", "CC"])
print(ll[1])

// Get part of the list
 list1[0..3] // Returns ['a','b','c','d'] - including the edges.

// '.collect' creating new mapping to the list
assert [1,2,3].collect { it * 3 } == [3,6,9]

// .find() - Returns the first element
list.find {it>10}
// .findAll() - Returns all the elements
list.find {it>10}
// If no element is found the result is null

.indexOf('elementValue')   // Returns the first element or -1 if the element not exists.
.sum() // sum anything in the list
.join('-') // String join
.remove(elementIndex) // removing an item and return it. false is returned when the element not exists in the list.
// Injecting data by .inject()
assert [1,2,3].inject('count: ') { str , item -> str + item } == 'count: 123'


// Chaining by <<
// Use the << leftShift operator to append an element at the end of the list
// +=  concatenate items. Using lists it is connecting both lists together.

//list as an array - can use the [indexInListValue] to replace the existing item
assert [1,3,4].containsAll([1,4])       // `containsAll` will check that all elements are found
.count(elementValue) // 'counts' the repetitions number of the element.
[1,2,3,4,5].intersect([2,3,4,5]) // returns the intersection group.
list1.disjoint(list2) // Returns true if there are no equivalent values.

.sort() // Sorting by values in the list.
assert Collections.sort(list, comp) == [1, 2, -3, 5, 6, -7, 9];

assert Collections.nCopies(3, 'b') == [ 'b','b','b']


// *. - spread operator
