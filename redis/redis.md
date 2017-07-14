Redis - plural sight (11/02/2017)

What is Redis?
An open source key-value store.
Stores its data in memory (by default)

store data by a unique key.
the value can be structure data type.
Redis persists its data in the disk
Designed to run and be used from the system memory


Redis features:
Extremely fast - the speed has a cost
Support replication - makes Redis scalable.

Why Redis is different:
The focus is on documents stores in the database and using index to the document.
Store the data as a key - no indexing of any kind.

Access to the data is by the key.
There  is no mechanism of indexing.

Redis is actually REmote DIctionary Service

Redis version 3.2 (Feb 2017)

Redis client:

String Get and Set:

Running the redid-cli.exe to execute the Redis commands:

Set string key value 
set user “name: joe”
get user —> “name: joe”

set JSON:
set user:1 “{‘name’: ’joe’, ‘email’: ‘joe@joe.com’ }”

get user:1 - returns all the JSON data 

set user:id 1

incr user:id —> return 2

get userid —> returns 2

append user:1 “extra data”
getrange customer:1 5 9 — returns the customer:1 value substring between the 5 and the 9 position


mset order:1 “order:1 data” order:2 “order:2 data”

get order:1 order:2


List
List of string ordered by the insertion order. (sorted by the insertion order)
LPUSH - insert an element to the left side of the list
RPUSH - insert an element to the right side of the list
LREM - remove element from the list
LINDEX - returns the element by its index.
LRANGE  -returns range of values.
LLEN - the length if the list
LPOP RPOP
LTRIM

Lists can be easily act like a queue or stack

LRANGE <key> 0 1 —> returns the first element in the list  (from Zero not included the 1’th position)








