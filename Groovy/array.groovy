

// -------------  Array  ---------------- //
Groovy reuses the list notation for arrays, but to make such literals arrays, you need to explicitely define the type of the array through coercion or type declaration.

String[] arrStr = ['Ananas', 'Banana', 'Kiwi']
assert arrStr instanceof String[]    
assert !(arrStr instanceof List)
// as operator defines the type of the array
def numArr = [1, 2, 3] as int[]      
assert numArr instanceof int[]


