

// --------------------- Test ------------------------ //

grails test-app

open test-report // open HTML report

grails test-app SimpleController // run all tests for controller 
grails test-app *Controller

grails test-app some.org.* // running all the tests in the package
      
//Test Mixins
@TestFor(BookController)  // This is the class under test. automatically create a field for the type of class under test
@Mock([Book, Author, BookService]) // The Mock annotation creates mock version of any collaborators


import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(BookController)
@Mock(Book)
class BookControllerSpec extends Specification {

    void "test search"() {
        given:
        def searchMock = mockFor(SearchService)
        searchMock.demand.searchWeb { String q -> ['first result', 'second result'] }
        searchMock.demand.static.logResults { List results ->  }
        controller.searchService = searchMock.createMock()

        when:
        controller.search()

        then:
        controller.response.text.contains "Found 2 results"
    }
}


// doWithSpring and doWithConfig callback methods, FreshRuntime annotation
//Callback method can be used to add beans with the BeanBuilder DSL
static doWithSpring = {
    myService(MyService)
}

//Callback method for changing the grailsApplication.config values.
static doWithConfig(c) {
    c.myConfigValue = 'Hello'
}

/*
the static keyword define 1 running of that method
without it every time the method runs the doWith... runs
*/

// @FreshRuntime - the test gets a fresh TestRuntime instance
// This annotation is required for enabling doWithSpring/doWithConfig callbacks that work with the test instance.
@FreshRuntime
@TestMixin(GrailsUnitTestMixin)
class TestInstanceCallbacksSpec extends Specification {
    def doWithSpring = {
        myService(MyService)
    }

    def doWithConfig(c) {
        c.myConfigValue = 'Hello'
    }

    def "grailsApplication is not null"() {
        expect:
        grailsApplication != null
    }

    def "doWithSpring callback is executed"() {
        expect:
        grailsApplication.mainContext.getBean('myService') != null
    }

    def "doWithConfig callback is executed"(){
        expect:        
        config.myConfigValue == 'Hello'
    }
}

/*
Loading application beans in unit tests
Adding static loadExternalBeans = true field definition to a unit test class makes the Grails unit test runtime load all bean definitions from grails-app/conf/spring/resources.groovy and grails-app/conf/spring/resources.xml files
*/

import spock.lang.Issue
import spock.lang.Specification
import grails.test.mixin.support.GrailsUnitTestMixin
@TestMixin(GrailsUnitTestMixin)
class LoadExternalBeansSpec extends Specification {
    static loadExternalBeans = true   // This is the addition.

    void "should load external beans"(){
        expect:
        applicationContext.getBean('simpleBean') == 'Hello world!'
    }
}

//14.1.1
//Unit Testing Controllers
//Adding the '@TestFor' annotation to a controller causes a new controller field to be automatically created for the controller under test.
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void "test something"() {
    }
}

// Testing the simple hello
class SimpleController {
    def hello() {
        render "hello"
    }
}

// Rendering View and Model
// The views are save in the following location:  'grails-app/views/simple/_hello.gsp.' 
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test home'() {
        when:
        controller.home()

        then:
        view == '/simple/homePage'
        model.title == 'Hello World'
    }
}

// Testing XML and JSON Responses
// XML and JSON response are also written directly to the response. 
// Grails' mocking capabilities provide some conveniences for testing XML and JSON response.
def renderXml() {
    render(contentType:"text/xml") {
        book(title:"Great")
    }
}

import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test render xml'() {
        when:
        controller.renderXml()

        then:
        response.text == "<book title='Great'/>"
        response.xml.@title.text() == 'Great'
    }
}


// Json

def renderJson() {
    render(contentType:"application/json") {
        book = "Great"
    }
}

// Test For Json
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test render json'() {
        when:
        controller.renderJson()

        then:
        response.text == '{"book":"Great"}'
        response.json.book == 'Great'
    }
}

// Testing files uploads
def uploadFile() {
    MultipartFile file = request.getFile("myFile")
    file.transferTo(new File("/local/disk/myFile"))
}

// GrailsMockMultipartFile
import grails.test.mixin.TestFor
import spock.lang.Specification
import org.codehaus.groovy.grails.plugins.testing.GrailsMockMultipartFile

@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test file upload'() {
        when:
        def file = new GrailsMockMultipartFile('myFile', 'some file contents'.bytes)
        request.addFile file
        controller.uploadFile()

        then:
        file.targetFileLocation.path == '/local/disk/myFile'
    }
}

// Testing Command Objects
// mockCommandObject method
class SimpleController {
    def handleCommand(SimpleCommand simple) {
        if(simple.hasErrors()) {
            render 'Bad'
        } else {
            render 'Good'
        }
    }
}
class SimpleCommand {
    String name

    static constraints = {
        name blank: false
    }
}

// 14.1.3 Unit Testing Domains
//Domain class interaction can be tested without involving a real database connection using 'DomainClassUnitTestMixin' or by using the 'HibernateTestMixin'

/*
Testing Constraints
There are 4 types of validateable classes:

1) Domain classes
2) Classes marked with the Validateable annotation
3) Command Objects which have been made validateable automatically
4) Classes configured to be validateable via the grails.validateable.classes property in Config.groovy
*/


14.1.8 Unit Test Metaprogramming
If runtime metaprogramming needs to be done in a unit test it needs to be done early in the process before the unit testing environment is fully initialized. This should be done when the unit test class is being initialized
For a Spock based test this should be done in the setupSpec() method
For a JUnit test this should be done in a method marked with @BeforeClass.

package myapp
import grails.test.mixin.*
import spock.lang.Specification

@TestFor(SomeController)
class SomeControllerSpec extends Specification {


    def setupSpec() {
        SomeClass.metaClass.someMethod = { ->
            // do something here
        }
    }
    
    @BeforeClass
    static void metaProgramController() {
        SomeClass.metaClass.someMethod = { ->
            // do something here
        }
    }



    // …
}

14.2 Integration Testing
Integration tests differ from unit tests in that you have full access to the Grails environment within the test. 
Grails uses an in-memory H2 database for integration tests and clears out all the data from the database between tests.

 class MyServiceTests extends GroovyTestCase {
    void testSomething() {
        log.info "Starting tests"
        …
    }
}

Transactions
Integration tests run inside a database transaction by default, which is rolled back at the end of the each test.
This means that data saved during a test is not persisted to the database. Add a transactional property to your test class to check transactional behaviour:
Grails automatically configures each test with:
    - MockHttpServletRequest, 
    - MockHttpServletResponse,  
    - MockHttpSession 
    

// Testing with JSON
void testCreateWithJSON() {
    def controller = new BookController()

    controller.request.contentType = "application/json"
    controller.request.content =
            '{"id":1,"class":"Book","title":"The Stand"}'.getBytes()

    def model = controller.create()
    assert model.book
    assertEquals "The Stand", model.book.title
}

// Testing Tag Libraries
// Code:
import java.text.SimpleDateFormat
class FormatTagLib {
    def dateFormat = { attrs, body ->
        out << new SimpleDateFormat(attrs.format) << attrs.date
    }
}

// Test: 
class FormatTagLibTests extends GroovyPagesTestCase {
    void testDateFormat() {
        def template =
                '<g:dateFormat format="dd-MM-yyyy" date="${myDate}" />'
        def testDate = … // create the date
        assertOutputEquals('01-01-2008', template, [myDate:testDate])
    }
}


// junit.framework.TestCase
GroovyTestCase is inherited from junit.framework.TestCase 

class MyTestCase extends GroovyTestCase {

    void testAssertions() {
        assertTrue(1 == 1)
        assertEquals("test", "test")

        def x = "42"
        assertNotNull "x must not be null", x
        assertNull null

        assertSame x, x
    }
}

void testInvalidIndexAccess1() {
    def numbers = [1,2,3,4]
    shouldFail {
        numbers.get(4)
    }
}


