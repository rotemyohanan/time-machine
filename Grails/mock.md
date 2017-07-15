

Mock in the Grails 3.1 and up Tests


Grails 3.1 and Up
=================
1. add import for groovy's MockFor: import groovy.mock.interceptor.MockFor
2. rename mockFor to new MockFor
3. rename createMock() to proxyInstance()
4. remove calls to verify()
    
    
