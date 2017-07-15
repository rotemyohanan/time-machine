

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
