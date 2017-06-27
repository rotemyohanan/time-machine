// Links  
// http://hmkcode.com/mongodb-java-querying/ -- querying OR, AND, ... 

String personIdentifier = "aba";
def people = Person.getCollection()
BasicDBObject query = new  Document("username",  java.util.regex.Pattern.compile(personIdentifier))
def results = people.find(query).sort() // returns order list of the persons in the people collection meets the regexp pattern. 

  
  
  
