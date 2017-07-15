// --------------- Grails Asynchronous Proggramming --------------- //
/*
Promises:
A Promise is a concept being embraced by many concurrency frameworks.
They are similar to java.util.concurrent.Future 
include a more user friendly exception handling model, 
    useful features like chaining and the ability to attach listeners.
*/
import static grails.async.Promises.*
    
//To create promises you can use the task method, which returns an instance of the grails.async.Promise interface:
def p1 = task { 2 * 2 }
def p2 = task { 4 * 4 }
def p3 = task { 8 * 8 }
assert [4,16,64] == waitAll(p1, p2, p3) // waits synchronously blocking the current thread, 

//If you prefer not to block the current thread you can use the onComplete method:
onComplete([p1,p2,p3]) { List results ->
   assert [4,16,64] == results
}

// Register an onError listener if you wish to handle exceptions without blocking:
onError([p1,p2,p3]) { Throwable t ->
   println "An error occured ${t.message}"
}

//Promise Chaining
//It is possible to chain several promises and wait for the chain to complete using the then method:


// Working with Promises is enabled for lists and for map.




//Code examples:
import static grails.async.Promises.task
import static grails.async.Promises.waitAll
 
def task1 = task {
    println "task1 - starting"
    Thread.sleep(5000)
    println "task1 - ending"
}
 
def task2 = task {
    println "task2 - starting"
    Thread.sleep(1000)
    println "task2 - ending"
}
 
waitAll(task1, task2)


// Complex example - running multifiles zip from defferent servers.
import static grails.async.Promises.task
import static grails.async.Promises.waitAll
 
def tasks = ["74172", "64840", "67202", "68508", "37201"].collect { z ->
    task {
        println "getting state for zip code: $z"
        def response = new URL("http://zip.getziptastic.com/v2/US/$z").content.text
        def json = grails.converters.JSON.parse(response)
        println "zip code $z is in state $json.state"
    }
}
 
waitAll(tasks)
