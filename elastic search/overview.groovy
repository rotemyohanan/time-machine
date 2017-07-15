
// ----------------- Elastic search -------------- //

Running ES in the IntelliJ idea:
===============================
    
Run Elastic Search integration tests in Grails 2.4.4, you will need to do couple of things:

1. Make sure the application is running (The si-sync need it for mapping request).
2. Run the SearchIndexSyncRunner (si-sync) in test mode. Need to add the VM option:
-Dspring.profiles.active=TEST 
    (This is important since the connection to the DB changes between development and test environments).
3. Run the test.

This behavior will change in grails 3 but for now, please use this instructions.
    
Tips:
Integration tests.
Add the following line after changing data in the artifact:
    'searchIndexService.createAndRefreshIndex(oldArtifact)'

Download the ElasticSearch:
==========================
wget https://download.elastic.co/elasticsearch/elasticsearch/elasticsearch-1.7.2.tar.gz
tar -zxvf elasticsearch-1.7.2.tar.gz
cd elasticsearch-1.7.2
bin/elasticsearch

The ElasticSearch is running on port:9200

checking connection ot the ElasticSearch:
Write in the shell  'curl http://localhost:9200'
Check the response and see if it is a valid response (Status code 200)

Requests examples:

curl -XPUT 'http://localhost:9200/blog/user/dilbert' -d '{ "name" : "Dilbert Brown" }'

curl -XPUT 'http://localhost:9200/blog/post/1' -d '
{ 
    "user": "dilbert", 
    "postDate": "2011-12-15", 
    "body": "Search is hard. Search should be easy." ,
    "title": "On search"
}'

// ---- GET ---- //
curl -XGET 'http://localhost:9200/blog/user/dilbert?pretty=true'
curl -XGET 'http://localhost:9200/blog/post/1?pretty=true'
curl -XGET 'http://localhost:9200/blog/post/2?pretty=true'
curl -XGET 'http://localhost:9200/blog/post/3?pretty=true'


// Search from date:
curl -XGET 'http://localhost:9200/blog/_search?pretty=true' -d '
{ 
    "query" : { 
        "range" : { 
            "postDate" : { "from" : "2011-12-10", "to" : "2011-12-12" } 
        } 
    } 
}'

// Update document 
curl -XPOST 'localhost:9200/test/type1/1/_update' -d '{
    "doc" : {
        "name" : "new_name"
    },
    "detect_noop": false
}'

// ------ Sense commands:

GET com.jfrog.bintray.interaction.domain/repo/_mapping
GET com.jfrog.bintray.interaction.domain/repo/_search/

GET com.jfrog.bintray.interaction.domain/package/_mapping



{
  "filtered" : {
    "query" : {
      "multi_match" : {
        "query" : "ant-1.7.0.pom",
        "fields" : [ "name", "name.untouched" ]
      }
    },
    "filter" : {
      "bool" : {
        "must" : [ {
          "query" : {
            "match" : {
              "status" : {
                "query" : "PUBLISHED",
                "type" : "boolean"
              }
            }
          }
        }, {
          "query" : {
            "match" : {
              "owner.id" : {
                "query" : "56c09e7ae98a03a710ef3e72",
                "type" : "boolean"
              }
            }
          }
        }, {"query" : {"range" : {"createdAfter" : {"from" : "2016-01-01T17:34:22.674+02:00","to" :"2016-03-29T19:05:22.627+03:00","include_lower" : true,"include_upper" : true}}}}, {
          "query" : {
            "match" : {
              "privacy" : {
                "query" : "PUBLIC",
                "type" : "boolean"
              }
            }
          }
        } ]
      }
    }
  }
}

/===============================================================================

  {
    "name": "ant-1.7.0.pom",
    "path": "org/apache/ant/ant/1.7.0/ant-1.7.0.pom",
    "repo": "central",
    "package": "org.apache.ant:ant",
    "version": "1.7.0",
    "owner": "joebloggs",
    "created": "2016-02-14T17:34:43.939+02:00",
    "size": 9758,
    "sha1": "7c0217403f57a200cb80d489892ce04ea762f2a133abe3dd38470651434cfaf2"
  }


======================================================================================
    
    {
  "filtered" : {
    "query" : {
      "multi_match" : {
        "query" : "ant-1.7.0.pom",
        "fields" : [ "name", "name.untouched" ]
      }
    },
    "filter" : {
      "bool" : {
        "must" : [ {
          "query" : {
            "match" : {
              "status" : {
                "query" : "PUBLISHED",
                "type" : "boolean"
              }
            }
          }
        }, {
          "query" : {
            "match" : {
              "owner.id" : {
                "query" : "56c09e7ae98a03a710ef3e72",
                "type" : "boolean"
              }
            }
          }
        }, {
          "query" : {
            "range" : {
              "createdAfter" : {
                "from" : "2016-01-01T17:34:22.674+02:00",
                "to" : "2016-03-29T19:09:22.438+03:00",
                "include_lower" : true,
                "include_upper" : true
              }
            }
          }
        }, {
          "query" : {
            "match" : {
              "privacy" : {
                "query" : "PUBLIC",
                "type" : "boolean"
              }
            }
          }
        } ]
      }
    }
  }
}
