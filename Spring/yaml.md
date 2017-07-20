
Data serialization language / format

Yaml vs properties
- has its own spec
- human readability
- key-value (Map), List and Scalar types
- Used in many languages (Python / Ruby / Elastic search / MongoDB)
- Hirerachical structure 
- Does not work with @PropertySource
- Multiple Spring profiles in default config (in 1 single file)


### YAML Basics:

properties: **key** values are **String**

yml keys are **String** values are respective type
 
 Define a Map as value to the key
 properties (.) denote hierarchy     
 
     somemap.key = value
     
#### .yml map:
 
     somemap:
        key: value
        number: 9
         
Inline map: (similar to JSON)

     someMap: {bool=true, date=2016-01-01}

#### .yml List:

    numbers:
     - one
     - two
    
Inline list

    numbers: [one, two]
    


Create a file calls application.yml (should contains all the properties in the application.properties)

    multipart:
       maxFileSize: 50MB
       maxRequestSize: 50MB
       location: ${java.io.tmpdir}
       
spring:
   mvc:
      favicon:
          enabled: false
          
logging:
  level.: DEBUG // the . is DEBUG at the Root level (else remove the dot.)
  
  
     

