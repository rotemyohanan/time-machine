

GSP (Groovy Server Pages) these are views and templates to create content we want to display in the web browser. 

The 'groovyPageRenderer':
----------------------
'groovyPageRenderer' instance to render GSP views and templates outside a controller. 

For example we can render content in a service or other classes outside the scope of a web request.

 type of 'grails.gsp.PageRenderer'
 
 Methods:
 
 render() method like we use in a controller.//We can pass a view or template name together with a model of data to be used in the GSP. 
     
 renderTo() // generate output to a Writer object
 
 The result is a String value.
     
     
=============================================
dir: grails-app/views/email/_welcome.gsp 
    
     
<g:render template="/email/welcome" model="[username: username]"/>
    
    

Spring has a view rendering engine.
    
Spring Boot will automatically use and configure <filename> as the view rendering engine, as long as it's on the classpath. To put it on the classpath use:
 
    compile("org.springframework.boot:spring-boot-starter-<filename>")
    
in the Gradle build file.
    
The related view file that we wish to display should be set in the '/resources/templates/'
    
Reference: 'https://spring.io/guides/gs/handling-form-submission/'
    
    
    
TODO:
1) src/main/resources/templates/settings.xml
    
    
reference: 
---------
    http://mrhaki.blogspot.co.il/2012/03/grails-goodness-render-gsp-views-and.html


    
