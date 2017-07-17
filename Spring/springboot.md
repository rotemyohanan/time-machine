### Spring Boot

A brand new framework from the team at Pivotal. 
Designed to simplify the bootstrapping and development of a new Spring application. 
The framework takes an opinionated approach to configuration, 
freeing developers from the need to define boilerplate configuration.



spring boot 

1) use the spring initializer as a bootstrap to start the project.

Bootstrap contains all the boiler plates for the application.

2) click generate project

'curl start.spring.io/starter.zip' -o demo.zip -d dependenies=web.actuator -d application'
'curl start.spring.io/starter.zip' -o demo.zip --data @option'

--data @option

option is a file.


Intellij Idea:
--------------
choose Spring initializer

@RestController  - mapping the UploadController.


@RequestMapping(value ="/upload" method = RequestMethod.POST, produces = MediaType.IMAGE_GIF_VALUE)

Logger factory as a Logger



'application.propertoes' file contains all the properties
    
    multipart.location=${java.io.tmpdir}  
    server.port=9000

spring boot dev tools - enable the automatic restart.
This is a very important feature to minimizing the restart time of the application.
        
        
@EnableAutoConfiguration
        - review 
        - Tuning
        - Demystifying
        - writing your own
        
Spring highly configurable:
questions should be asked:

Web application / desktop application
    - frontend?
    - data access?
    - security ?
    
    
Auto configuration is a must when using Spring Boot

Conditions:
1) Presence/Absence of a jar.
2) Presence/Absence of a Bean.
3) Presence/Absence of a Property.

    
MongoDB cursor:
A pointer to the result set of a query. Clients can iterate through a cursor to retrieve results.
        
        
        
Application properties:
 
 @ConditionalOnMissingBean
 
 
 
#### Application properties:

spring.dao.exceptiontranslation.enabled = false

spring.mvc.favicon.enabled=false

look for the link of the #common-application-properties

@Bean - define custom bean

Exclude Auto configured servlet or filter

@FilterRegistrationBean
@ServletRegistrationBean

completely custom annotation:

Remove @EnableAutoConfiguration and manually configure array of auto configuration @Configuration and @Import


@PostConstruct

default is the **JacksonAutoConfiguration**  - duing all the marshaling and unmarshaling of the JSON, hance this is very good for web applications.

When I wan to exclude a bean from the auto configuration.

    @SpringBootApplication(exclude = {JacksonAutoConfiguration.class, JmxAutoConfiguration.class, WebSocketAutoConfiguration.class})
    
The exclude gets and array of classes


 **HiddenHttpMethodFilter** registered by default with the **WebMvcAutoConfiguration**
 
 

In the **application.properties** set :
 
    spring.mvc.favicon.enabled=false
    
    

    RequestContextFilter
    
    
#### @ConditionalOn... Annotation

conditions - method matches() - main method in order for a component to be registered.

Presence or Absence of class on Classpath

Conditions:
  
    @ConditionalOnClass // aplly this conf if the class exists in the class path.
    @ConditionalOnMissingClass
        
    @ConditionalOnBean
    @ConditionalOnMissingBean

    @ConditionalOnProperty
    @ConditionalOnMissingProperty
    
    
#### Custom Auto configuration:

In the class level add the following annotations:

    @Configuration
    @ConditionalOnClass({FFmpegFrameGrabber.class, AnimatedGifEncoder.class})


     
