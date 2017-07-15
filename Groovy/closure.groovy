

Convert a method to a closure with the .& operator



// --------------    Closures   ----------------- //
/*
    Behaves like a field
*/

// Implicit 
(1) def greeting = { "Hello, $it!" }
    assert greeting('Patrick') == 'Hello, Patrick!'

(2) def greeting = { it -> "Hello, $it!" }

// (1) & (2) are equivalent.


// declare a closure which accepts no argument and must be restricted to calls without arguments
def magicNumber = { -> 42 }

assert magicNumber() == 42

// varargs - accepts a variable number of arguments 
def concat1 = { String... args -> args.join('') }           
assert concat1('abc','def') == 'abcdef'                     
def concat2 = { String[] args -> args.join('') }            
assert concat2('abc', 'def') == 'abcdef'

def multiConcat = { int n, String... args ->                
    args.join('')*n
}
assert multiConcat(2, 'abc','def') == 'abcdefabcdef'


// -------  Delegation strategy  ------- //
// 1. 'this' corresponds to the enclosing '''class''' where the closure is defined
// 2. 'owner' corresponds to the enclosing '''object''' where the closure is defined, which may be either a class or a closure
// 3. 'delegate' corresponds to a third party object where methods calls or properties are resolved whenever the receiver of the message is not defined

// getThisObject()
def whatIsThisObject = { getThisObject() } // returns the 'this' 
// getOwner()
def whatIsOwnerMethod = { getOwner() } 
// delegate of a closure is a property
//  the delegate is a user defined object that a closure will use, By default, the delegate is set to owner:
def cl = { getDelegate() }
