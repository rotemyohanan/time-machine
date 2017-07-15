
// ---------------------  Elastic search  ------------------------ //
Documents are indexed—stored and made searchable—by using the index API
A document’s _index, _type, and _id uniquely identify the document.
    
    
only=['id','name','path', 'dateCreated']

each field in the class that is indexed has no attributes in the searchable.


extract=[]



Every document in Elasticsearch has a version number.
Every time a change is made to a document (including deleting it), the _version number is incremented

Autogenerating IDs:
    
This is for not natural ID.

    

?pretty=true
    

Elasticsearch has dynamically generated a mapping for us, based on what it could guess about our field types.
    
Date is a type of date

    
Syntax:
The _shared header inforamtion about the replication process of the index operation    
{
    "_shards" : {
        "total" : 10,
        "failed" : 0,
        "successful" : 10
    },
    "_index" : "twitter",
    "_type" : "tweet",
    "_id" : "1",
    "_version" : 1,
    "created" : true
}


curl -XGET 'http://localhost:9200/twitter/tweet/1'

Success response: the '_source' of the document represent the result object
{
    "_index" : "twitter",
    "_type" : "tweet",
    "_id" : "1",
    "_version" : 1,
    "found": true,
    "_source" : {
        "user" : "kimchy",
        "postDate" : "2009-11-15T14:12:12",
        "message" : "trying out Elasticsearch"
    }
}

Mapping:
Mapping is the process of defining how a document, and the fields it contains, are stored and indexed.

which string fields should be treated as full text fields.
which fields contain numbers, dates, or geolocations.
whether the values of all fields in the document should be indexed into the catch-all _all field.
the format of date values.
custom rules to control the mapping for dynamically added fields.

    

    
Re-Index of the ES:
    
In order to do so, you need to do the following:
1. checkout es-mtn project
2. run main with the following program arguments:
-e development -d <DOMAIN>
the domains are: Subject, Repo, Package, Version, Artifact, ElementLink, ArtifactLink
