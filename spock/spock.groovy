// --------------------- Spock --------------------- //
/*
Spock lets tou write Specifications that describe expected features(properties, aspects)
SUS - System Under Specification
*/
import spock.lang.*
    


//Specification
class MyFirstSpecification extends Specification {}   // spock.lang.Specification

//Expensive fields
@Shared res = new VeryExpensiveResource() // it's best to initialize the field right at the point of declaration
//or
//Initializing object at the setupSpec() 

//Constants
static final PI = 3.141592654   // Static fields should only be used for constants

//Fixture methods
def setup() {}     // run before every feature method 
def cleanup() {}   // run after every feature method
def setupSpec() {} // run before the first feature method
def cleanupSpec() {}   // run after the last feature method

//Feature Methods - these are the heart of a specification
def "pushing an element on the stack"() { // blocks go here }
// Feature methods are structured into so-called blocks.
//There are six kinds of blocks: 
    setup, when, then, expect, cleanup, & where blocks
//Any statements between the beginning of the method and the first explicit block belong to an implicit setup block.
//A feature method must have at least one explicit (i.e. labelled) block
//Blocks divide a method into distinct sections, and cannot be nested
//Setup Blocks: where to make setup work for the feateure 
    setup: def stack = new Stack() def elem = "push me"
// given: ia an alias to setup
        
//When and Then Blocks
when: // stimulus 
then: // response, restricted to conditions, exception conditions, interactions, and variable definitions.
// A feature method may contain multiple pairs of when-then blocks. 

//Conditions:
//conditions are written as plain boolean expressions
    
where: (example)
class DataDriven extends Specification {
    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }
}
