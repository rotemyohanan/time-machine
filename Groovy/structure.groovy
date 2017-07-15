

// -----------------  Groovy Structure ----------------- //

// Scripts groovy
/*A script is always compiled into a class. The Groovy compiler will compile the class for you, with the body of the script copied into a run method.
it is compiled into the following:
*/
import org.codehaus.groovy.runtime.InvokerHelper
class Main extends Script {                     
    def run() {                                 
        println 'Groovy world!'                 
    }
    static void main(String[] args) {           
        InvokerHelper.runScript(Main, args)     
    }
}



// Groovy compiler
groovyc // is the Groovy compiler command line tool.
//It allows you to compile Groovy sources into bytecode. It plays the same role as javac in the Java world.
groovyc MyClass.groovy




Log files:
success Zuora:
 'Finished executing request and handling response HTTP/1.1 200 OK'

Successfuly received by user:
    'Successfully received user usage by url with the following result: {"usage":[{"id":"2c92a09a52e8e0480152ec882b6c3013" '

               "id":"2c92a09a52e8e0480152ec88d70230db" // difference are in the suffix.



    String logLine = "» 1 (c.j.b.a.SubjectAuditService:-2) Starting an Audit process for homebrew (54db89c8ed50b9267e3707cd)"
    def startCharValue = logLine.indexOf('Starting an Audit process for')
    Integer vall = startCharValue + 'Starting an Audit process for'.length()
    String substr = logLine.substring(vall)
    println substr
    Integer openBracket = substr.indexOf("(")
    Integer closeBracket = substr.indexOf(")")
    println substr.substring(openBracket+1,closeBracket)
    println "========================"
    def del = substr.tokenize("()");
    users.put(del[0],del[1])
    println "99999999999999"
    println "del[1] " + del[1]
    println users.get(del[0])
    println " - - - - - - - - - - - - - "
