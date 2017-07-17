
Data serialization language / format

High use by python and ruby and Elastic search and MongoDB use Yaml

Yaml vs properties
- has its own spec
- human readability
- key-value (Map), List and Scalar types
- Used in many languages (Python / Ruby)
- Hirerachical structure 
- Does not work with @PropertySource
- Multiple Spring profiles in default config (in 1 single file)


### YAML Basics:

properties: key values are String
 yml keys are String values are respective type
 
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
    

     

