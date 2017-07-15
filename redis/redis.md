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



// --------------- Redis --------------- //

// installation
wget http://download.redis.io/redis-stable.tar.gz
tar xvzf redis-stable.tar.gz
cd redis-stable
make

// Info

This is a data structure server (not key-value store), This is not relational Database (like mongo)
The value is not limited. (holds complex data structures/types) - atomic operations

String, List, Set, Sorted Set, Hashed, Bit array (bitmaps)

Redis is written in ANSI C and therefore does not have a VM
Redis is an in-memory but persistent on disk database

adv of the in memeory: 
    1. very high write and read (if the context is smaller than the memory size)
    2. the memory representation of complex data structures is much simpler to manipulate compared to the same data structure on disk, so Redis can do a lot, with little internal complexity
    3. 
    

Keys:
Redis keys - binary safe.
"comment:1234:reply.to" or "comment:1234:reply-to" // these are good examples.
small keys: key -> String pair
Keys: key -> Hash value

 

Commands:
             <ip-host>
redis-cli -h 5.153.35.251 ping  // Return PONG for existing connection
// Full command
$ redis-cli -h host -p port -a password


npm install redis


command line should start with the prefix:
    redis-cli -h <ip-number> (5.153.35.251)

String value (main methods):
    DEL
    DUMP - returns serialized version of the value stored at the specified key
    EXISTS
    SET - format should be: <key> <value>
    GET
    KEYS <keyname> returns the key if it exists else (empty list or set)
   
        
List value (main methods):
When insert a list it behaves like a stack - 'LIFO' (When LPUSH is the insertion command)

    LRANGE <startIndex> <endIndex> // zero based
    LPUSH <key> <value>
    RPUSH <key> <value> // insert into the right side of the list

LRANGE <key> 0 1 —> returns the first element in the list  (from Zero not included the 1’th position)








