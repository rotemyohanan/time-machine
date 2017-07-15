

class <class-name> extends Specification {

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




// test/unit/com/demo/DemoControllerSpec.groovy
package com.demo
import grails.test.mixin.TestFor
import spock.lang.Specification
import static javax.servlet.http.HttpServletResponse.*

@TestFor(DemoController)
class DemoControllerSpec extends Specification {

    void "test a valid request method"() {
        when:
        request.method = 'POST'
        controller.save()

        then:
        response.status == SC_OK
        response.text == 'Save was successful!'
    }

    void "test compare 1 to 1"() {
        expect:
        	1==1;
    }

    void "test when then"() {
        when:
        controller.hello()
        then:
        response.text == 'hello'
    }
}





If you use @Unroll, then cleanup: will be called for every entry in the where: block. To only run cleanup once then move your code inside the def cleanupSpec() closure.
    
    
// Grails 3 features
replace: mockFor() with new MockFor()
replace: createMock() with proxyInstance()
replace: fooBean.fooService = fooService.proxyInstance() to after the demands
