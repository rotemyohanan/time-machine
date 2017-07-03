

// DBCursor result as a List, the sort() is critical to get a list. 
  List<DBObject> myList = null;
  DBCursor myCursor=myCollection.find().sort(new BasicDBObject("date",-1)).limit(10);
  myList = myCursor.toArray();
