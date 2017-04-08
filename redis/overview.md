Redis
------------------------------------------------------------------------------------------------------------------------

Running the service:  './redis-server'

Running the Redis console: './redis-cli'
    
What Redis is?
-------------------------------------------------------------------------------------------------------------------------
Redis is often described as an in-memory persistent key-value store. 
Redis holds all the data in memory, and it does write that out to disk for persistence, but it’s much more than a simple key-value store.


Actually Redis exposes five different data structures, only one of which is a typical key-value structure.

In Redis, databases are simply identified by a number with the default database being number 0. If you want to change to a different database you can do so via the select command.

127.0.0.1:6379[1]>
    
Go to default database 'SELECT 0' and ENTER
    
Key values:
-----------

Keys: are how you identify pieces of data.
Values: represent the actual data associated with the key.

For the most part, Redis treats values as a byte array and doesn’t care what they are.

Redis doesn’t allow you to query an object’s values.
    
Persistance: By default, Redis snapshots the database to disk based on how many keys have changed.
    
With respect to memory, Redis keeps all your data in memory. The obvious implication of this is the cost of running Redis: RAM is still the most expensive part of server hardware.
    
Redis doesn’t do auto-compression but, since it treats values as bytes, there’s no reason you can’t trade processing time for RAM by compressing/decompressing the data yourself.)
=========================================================================================
When you add those three things together you end up with something wonderful: speed. Some people think “Of course Redis is fast, everything’s in memory.” But that’s only part of it. The real reason Redis shines versus other solutions is its specialized data structures.
=========================================================================================
    
How fast? 
=========
Redis’ performance tends to be measured in tens of thousands, or hundreds of thousands of operations per second.
    
run 'redis-benchmark' (which is in the same folder as the 'redis-server' and 'redis-cli') to test it out yourself.

==========================================================================================
    
Concepts:
-------------------------------------------------------------------------------------------
• Keys are strings which identify pieces of data (values)
• Values are arbitrary byte arrays that Redis doesn’t care about
• Redis exposes five specialized data structures
• Combined, the above make Redis fast and easy to use, but not suitable for every scenario

Data Structures:
-------------------------------------------------------------------------------------------

'flushdb' - You can always ''erase all'' the values in your database by entering 'flushdb'.
    
Strings:
========
Strings are the most basic data structures available in Redis.
    
Common operations:
- strlen <key> can be used to get the length of a key’s value; 
- getrange <key> <start> <end> returns the specified range of a value; 
- append <key> <value> appends the value to the existing value (or creates it if it doesn’t   exist already).
    
Redis strings are great for analytics.
since getting a value by key is so fast, strings are often used to cache
data.
    
Hashs:
======

The important difference between string and Hash is that they provide an extra level of indirection.
example:  
--------
hset users:goku powerlevel 9000
hget users:goku powerlevel
    
set multiple fields at once, get multiple fields at once, get all fields and values, list all the fields or delete a specific field
example:  
-------
hmset users:goku race saiyan age 737
hmget users:goku race powerlevel
hgetall users:goku
hkeys users:goku
hdel users:goku age
    
As you can see, hashes give us a bit more control over plain strings. Rather than storing a user as a single serialized value, we could use a hash to get a more accurate representation. The benefit would be the ability to pull and update/delete specific pieces of data, without having to get or write the entire value.

Looking at hashes from the perspective of a well-defined object, such as a user, is key to understanding how they work. And it’s true that, for performance reasons, more granular control might be useful.
    
Lists
=====
Lists let you store and manipulate an array of values for a given key. You can add values to the list, get the first or last value and manipulate values at a given index. Lists maintain their order and have efficient index-based operations. 

    
code example:
lpush newusers goku   // First we push a new user at the front of the list
ltrim newusers 0 50   // trim it so it only contains the last 50 users
    
'ltrim' is an O(N) operation, where N is the number of values we are removing.

If we wanted to get the details of the last 10 users, we’d do the following combination:
keys = redis.lrange(’newusers’, 0, 10)
redis.mget(*keys.map {|u| ”users:#{u}”})
The above is a bit of Ruby.
    
The values can be anything. You could use lists to store logs or track the path a user is taking through a site.
    
Sets
====
Set are used to store unique values and provide a number of set-based operations, like unions.
    
Sets aren’t ordered but they provide efficient value-based operations. A friend’s list is the classic example of using a set:
    sadd friends:leto ghanima paul chani jessica
    sadd friends:duncan paul jessica alia

Regardless of how many friends a user has, we can efficiently tell (O(1)) whether userX is a friend of userY or not:
    sismember friends:leto jessica
    sismember friends:leto vladimir

Furthermore we can see what two or more people share the same friends:
    sinter friends:leto friends:duncan
    
and even store the result at a new key:
    sinterstore friends:leto_duncan friends:leto friends:duncan  

Sets are great for tagging or tracking any other properties of a value for which duplicates don’t make any sense (or where we want to apply set operations such as intersections and unions).
     
Sorted Sets
===========
    
The last and most powerful data structure are sorted sets. 
If hashes are like strings but with fields, then sorted sets are like sets but with a score. The score provides sorting and ranking capabilities. If we wanted a ranked list of friends,
we might do:
    zadd friends:duncan 70 ghanima 95 paul 95 chani 75 jessica 1 vladimir
Want to find out how many friends duncan has with a score of 90 or over?
    zcount friends:duncan 90 100
How about figuring out chani’s rank?
    zrevrank friends:duncan chani    
 
        
We use zrevrank instead of zrank since Redis’ default sort is from low to high (but in this case we are ranking from high to low).
    
    

O(1)
-sismember

O(log(N)):       
- zadd 

O(N):
- ltrim   N - the number that are removed from the list.

O(M + log(N)) - M = number of elements to be removed.   N=total elements.
-zremrangebyscore remove elements by score

O(N+M*log(M)):
sort (Redis’ most complex commands)
    
 
    
Redis also supports pipelining. Normally when a client sends a request to Redis it waits for the reply before sending
the next request. With pipelining you can send a number of requests without waiting for their responses. This reduces
the networking overhead and can result in significant performance gains.
    
    
Reached till 'Transactions'  page 18.
    
Transactions
------------
Every Redis command is atomic, including the ones that do multiple things. 
Additionally, Redis has support for transactions when using multiple commands.
    

    
 
    
