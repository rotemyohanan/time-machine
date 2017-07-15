// ------------ Groovy Testing -------------- //
/*
JUnit : for integration, 
Spock : for specifications,
Geb   : for functional tests


assert statements can be enabled via the JVM parameters -ea (or -enableassertions) and -da (or -disableassertions).
Assertion statements in Java are disabled by default.
Assertion statements in Groovy are enabled by default.
    
The java.lang.AssertionError that is thrown whenever the assertion can not be validated successfully
*/

// Real classes
class Person {
    String first, last
}

class Family {
    Person father, mother
    def nameOfMother() { "$mother.first $mother.last" }
}

// Fake classes - Mocking
def mock = new MockFor(Person)   // Creating new mock    
mock.demand.getFirst{ 'dummy' }
mock.demand.getLast{ 'name' }
mock.use {                      // Enable mocking functionality                    
    def mary = new Person(first:'Mary', last:'Smith')
    def f = new Family(mother:mary)
    assert f.nameOfMother() == 'dummy name'
}
mock.expect.verify() 


// Stub
def stub = new StubFor(Person)   // Creating new stub   
stub.demand.with {               // Delegating all calls inside the closure to the StubFor instance   
    getLast{ 'name' }
    getFirst{ 'dummy' }
}
stub.use {                      // Enable stubing functionality    
    def john = new Person(first:'John', last:'Smith')
    def f = new Family(father:john)
    assert f.father.first == 'dummy'
    assert f.father.last == 'name'
}
stub.expect.verify()


// Expendo Meta Class (EMC)

class Book {
    String title
}

Book.metaClass.constructor << { String title -> new Book(title:title) }

def b = new Book("The Stand")
assert b.title == 'The Stand'
