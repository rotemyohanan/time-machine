// Shebang line - means that the groovy distribution and the groovy command is available on the PATH
#!/usr/bin/env groovy

//'def' is a replacement for a type name (You can think of 'def' as an alias of java 'Object')
//We can change the type of objects with the 'as' keyword in Groovy. We can even make maps and closure look like interface implementations when we use 'as'. Furthermore we can use as to create an alias for an import statement

//Using the as keyword is only possible if you have a static reference to a class, like in the following code:

interface Greeter {
    void greet()
}
def greeter = { println 'Hello, Groovy!' } as Greeter // Greeter is known statically
greeter.greet()
//But what if you get the class by reflection, for example by calling Class.forName?
Class clazz = Class.forName('Greeter')
//Trying to use the reference to the class with the 'as' keyword would fail:
greeter = { println 'Hello, Groovy!' } as clazz // Failing line of code throws: unable to resolve class clazz

/*   'asType()'
In Groovy we can override the method 'asType()' to convert an object into another type. We can use the method 'asType()' in our code to invoke the conversion, but we can even make it shorter an use as.
*/

// When define a method in 'def' return value than the return type of the method is an 'Object'

// Multiple assignment
def (a, b, c) = [10, 20, 'foo']
assert a == 10 && b == 20 && c == 'foo'
//-------------------------------------------//
def (_, month, year) = "18th June 2009".split()
assert "In $month of $year" == 'In June of 2009'
// Overflow & underflow
def (a, b, c) = [1, 2]
assert a == 1 && b == 2 && c == null

def (a, b) = [1, 2, 3]
assert a == 1 && b == 2

//
//it - default parameter

//A power assertion is decomposed into 3 parts:
assert [left expression] == [right expression] : (optional message)

// The equasions:
// '==' - it is the equal to operator


//escaping single quote, by backslash ('\')
'an escaped single quote: \' needs a backslash'

//Strings
// If there is an interpolation than the string is groovy.lang.Gstring
// else the string is java.lang.String

// Placeholder expression
${} // Groovy allows expressions/statements between the brackets.
.$ // for dotted expressions.
// when passing GString as a parameter it turns into String by to String() automatically.
//expression example:
//${def a = 1; def b = 2; a + b}
    
// Gstring and String have different hashcode value.
//            GString {closure}       String
assert "one: ${1}".hashCode() != "one: 1".hashCode()

example:
def key = "a"
def m = ["${key}": "letter ${key}"]     // The key is GString
assert m["a"] == null                   // The key is String
/* The key is GString but we retrieve from the map String
    hence the map returns different hashcode and the key is not in the map and the reutrn value is null.
*/

// Slashy String , can be multiline. can be interpolated.
// using ('/') as a delimiter.
// Perefered for defining regular expressions and patterns.
def fooPattern = /.*foo.*/
assert fooPattern == '.*foo.*'

// ('//')- is a comment so it can't be defined as an empty slashy String.

/* 
Dollar slashy strings are multiline GStrings delimited with an opening ('$/') and and a closing ('/$').
*/

// ------------ Numbers ------------ //
Integer --> Long            -->  BigInteger
214783647   9223372036854775807  

// 0b prefix - means bytes
int xInt = 0b10101111
assert xInt == 175

// 0 prefix - For octal numbers. 
int xInt = 077
assert xInt == 63

// 0x - Hexadecimal
int xInt = 0x77
assert xInt == 119

// infinite precision - This is the wrapper to double and float
BigDecimal bd = 3.456

//Using ('_') in long number is an option to read the number.

/*  Number Types      Suffix*/
    BigInteger          G
    Long                L
    Integer             I
    BigDecimal          G
    Double              D
    Float               F


//  ('**') power operator

// && - AND
//  ! - NOT
// || - OR   // supports short-circuiting:

// The logical "not" has a higher priority than the logical "and".

/* bitwise operators:
    & AND
    | OR
    ^ XOR
    ~ Negative
*/    

 // -------------- Booleean  -------------- //
true
false
empty string = ''   // false
null                // false

// Elvis operator   ? :  . 
// Usage of the Elvis operator reduces the verbosity of your code and reduces the risks of errors in case of refactorings
// The Safe Navigation operator ('?.') is used to avoid a NullPointerException.
// The safe navigation operator will simply return null instead of throwing an exception
def person = Person.find { it.id == 123 } // person == null
def name = person?.name // This is the safe navigation ('?.') perevent from sending NullPointerException                
assert name == null

//  Direct field access.
assert user.@name == 'Bob' // use of ('.@') forces usage of the field instead of the getter

// Method pointer operator ('.&') - used to store a reference to a method.
def str = 'example of method reference'            
def fun = str.&toUpperCase // storing the pointer to future use.        
def upper = fun()                                  
assert upper == str.toUpperCase()
// Calling to the value from the method reference by using ('${}')
Adantages of using method dpointers:
1. The type of the method pointer is groovy.lang.Closure.
2. Arguments are resolved at runtime.

//The pattern operator (~) provides a simple way to create a java.util.regex.Pattern instance
def p = ~/foo/
assert p instanceof Pattern
// ~ can be used with any kind of String in Groovy.

// Find operator ('=~')  java.util.regex.Matcher, return type is a Matcher.
def text = " Rotem is the one who works on that computer";
def matcher = text =~ /is/
assert matcher instanceof java.util.regex.Matcher

// Match operator (==~), returns a boolean type.

// Spread operator (*.), used to invoke an action on all the items 

class Car {
    String make;
    String model;
}

def cars = [
    new Car(make: 'Peugeot', model:'508'),
    new Car(make: 'Renault', model:'Clio')
]

def makes = cars*.model
println makes    // Returns [508, Clio]

// Range operator    groovy.lang.range
assert (0..5) == [0,1,2,3,4,5]
// Any Comparable object that has next() and previous() methods

/*  Spaceship operator <=> , delegates to CompareTo.
    Returns -1 / 0 / 1 
    1 : when the left value is bigger.
    0 : when the values are equals.  
*/
assert (2 <=> 3) == -1 

// Subscript operator ('[]'), shorthand notation for getAt / putAt.

// Membership operator ( in / inCase )
def list = ['Grace', 'Rod', 'Emmy']
assert ('Emmy' in list)

// as - is a variant casting.
Integer x = 123
def s = x as String // Casting the x to String


/* GPath expressions:32q     
GPath is a path expression language integrated into Groovy which allows parts of nested structured data to be identified
GPath is often used in the context of processing XML, but it really applies to any object graph. Where XPath uses a filesystem-like path notation, a tree hierarchy with parts separated by a slash /, GPath use a dot-object notation to perform object navigation

One powerful feature of GPath expression is that property access on a collection is converted to a property access on each element of the collection with the results collected into a collection.

*/

SAM - Single abstarct method

Any closure can be converted into a SAM type using the as operator:

//Funcitonal interface
interface Predicate<T> {
    boolean accept(T obj)
}

// Map to tyoe coercion
interface X {
    void f()
    void g(int n)
    void h(String s, int n)
}

x = [ f: {println "f called"} ] as X
x.f() // method exists
x.g() // MissingMethodException here
x.g(5) // UnsupportedOperationException here

// String to enum coercion
enum State {
    up,
    down
}


// ----------------- Optionals ------------------- //
//4.1. Optional parentheses
//Method calls can omit the parentheses if there is 'at least one' parameter and there is no ambiguity:
println 'Hello World' // println()
def maximum = Math.max 5, 10 // Math.max(5,10)

//optional return value; the last expression evaluatred in the body of the method or closure is returned.

//By default, Groovy classes and methods are public.

// (6) Optional typing (dynamic casting)
// def is equivalent of using Object
// (6.2) static type checking
By default, Groovy performs minimal type checking at compile time


// Runtime and compile time metaprogramming
/*
The Groovy language supports two flavors of metaprogramming: runtime metaprogramming and compile-time metaprogramming. 

Runtime metaprogramming - allows altering the class model and the behavior of a program at runtime.
Compile-time metaprogramming - occurs at compile-time.

// 6.2.1. The @TypeChecked annotation - reading from here (groovy semantics)

*/


Pattern pattern = ~/^.*?groovy.*$/
The previous pattern will match any text that contains the word groovy in it.

