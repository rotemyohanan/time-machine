// -------------  Groovy Classes  ------------- //
1. Public fields are turned into properties automatically, which results in less verbose code, 
   without so many getter and setter methods
2. Classes declarations and any property or method without an access modifier are public.
3. Classes do not need to have the same name of the files where they are defined.
4. One file may contain one or more classes (but if a file contains no classes, it is considered a script).
    
example:
class Person {                       

    String name       // property (String field)                  
    Integer age

    def increaseAge(Integer years) { 
        this.age += years
    }
}   

/*
    Default definition for class is public
*/

// this - represents the implementing instance. 


// Abstract method signature.
abstract String name()

// Inner classes:
// Classes other than the enclosing class are not allowed to access inner classes.
// Only the enclosing class has an access to the inner class.
// Inner class has access to the enclosing class (even to private fields)
// Reasons for using inner classes
//     1. increase encapsulation (cleaner packages)
//     2. Good organization - there is a relation between the inner class and the outer class.
//     3. More maintainable code
// If there is an ability to create annonimous class then inner class, annonimous class is preffered.


// Traits:
/* Traits are a a structural construct of the language which allow:
    - composition of behaviors
    - runtime implementation of interfaces
    - behavior overriding
    - compatibility with static type checking/compilation

They can be seen as interfaces carrying both default implementations and state. A trait is defined using the trait keyword:
The trait may declare abstract methods too.
Traits may also define private methods. Those methods will not appear in the trait contract interface. 
It can also be interesting to use private fields to store state
*/

trait FlyingAbility {                           
        String fly() { "I'm flying!" }          
}

// Lets check the trait's state
trait Counter {
    private int count = 0                   
    int count() { count += 1; count }   // the return value should be omitted from the closure, the last parameter is returned.    
}

class Foo implements Counter {}             
def f = new Foo()
assert f.count() == 1                       
assert f.count() == 2
/*
This is a major difference with Java 8 virtual extension methods. While virtual extension methods do not carry state, traits can. Moreover, traits in Groovy are supported starting with Java 6, because their implementation does not rely on virtual extension methods. This means that even if a trait can be seen from a Java class as a regular interface, that interface will not have default methods, only abstract ones.
*/

/* Trait public fields:
The name of the field depends on the fully qualified name of the trait. All dots (.) in package are replaced with an underscore (_), and the final name includes a double underscore 
*/
trait Named {
    public String name                      
}

class Person implements Named {}            
def p = new Person()                        
p.Named__name = 'Bob'

// Traits can be used to implement multiple inheritance in a controlled way, avoiding the diamond issue.
// Trait can inherite from other trait by using extends keyword.
// Multiple inheritance will be done by the implements keyword.
// Trait can call any dynamic code (like any normal groovy class)
trait SpeakingDuck {
    String speak() { quack() }  // trait abstract method.
}

// Dynamic methods in Trait
trait DynamicObject {                               
    private Map props = [:]
    def methodMissing(String name, args) {
        name.toUpperCase()
    }
    def propertyMissing(String prop) {
        props[prop]
    }
    void setProperty(String prop, Object value) {
        props[prop] = value
    }
}

class Dynamic implements DynamicObject {
    String existingProperty = 'ok'    // Define a property.       
    String existingMethod() { 'ok' }  // Define a method.              
}
def d = new Dynamic()
assert d.existingProperty == 'ok'                   
assert d.foo == null                                
d.foo = 'bar'                                       
assert d.foo == 'bar'                               
assert d.existingMethod() == 'ok'                   
assert d.someMethod() == 'SOMEMETHOD' 

// Multiple inheritance conflicts is solved by the trait structure.
// Trait inheritance using 'extends'
trait A {
    String exec() { 'A' }               
}
trait B {
    String exec() { 'B' }               
}
class C implements A,B {}  // The last declared trait wins. in this case B wins.

// Choosing different implementation
class C implements A,B {
    String exec() { A.super.exec() }    
}

// Runtime implementation trait
trait Extra {
    String extra() { "I'm an extra method" }            
}
class Something {                                       
    String doSomething() { 'Something' }                
}

// To run in runtime the method extra, I should define it like that:
def s = new Something() as Extra // use of the as keyword to coerce an object to a trait at runtime                       
s.extra()                                               
s.doSomething()

// Implementing multiple traits at once
trait A { void methodFromA() {} }
trait B { void methodFromB() {} }

class C {}

def c = new C()
c.methodFromA()                     
c.methodFromB()                     
def d = c.withTraits A, B           
d.methodFromA()                     
d.methodFromB()


2.12  Chaining behaviour - keep reading from here.
