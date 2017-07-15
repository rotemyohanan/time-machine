// Spock Annotations

@TestFor(Controller-name)
@Mock(Class-name)

@FreshRuntime

@Shared // Sharing an  object between interactions
//can be also a ‘static field’
//only @Shared and ‘static variables can be accessed from within a ‘Where:’ block

//@Unroll
//A method annotated with @Unroll will have its iterations reported independently:

@Unroll
def "maximum of #a and #b is #c"() { ... }
//This method name uses placeholders, denoted by a leading hash sign (#), to refer to data variables a, b, and c. In the output, the placeholders will be replaced with concrete values


// Note: An unrolled method name is similar to a Groovy GString, except for the following differences:
// 1)Expressions are denoted with # instead of $ [3], and there is no equivalent for the ${…​} syntax.
// 2)Expressions only support property access and zero-arg method calls

Data pipes:
===========

where:
a << [3, 7, 0]
b << [5, 0, 0]
c << [5, 7, 0]

//A data pipe, indicated by the left-shift (<<) operator, connects a data variable to a data provider. The data provider holds all values for the variable, one per iteration.
//Any object that Groovy knows how to iterate over can be used as a data provider. This includes objects of type Collection, String, Iterable, and objects implementing the Iterable contract.

//Data values that aren’t of interest can be ignored with an underscore (_):
...
where:
[a, b, _, c] << sql.rows("select * from maxdata")

Data tables, data pipes, and variable assignments can be combined as needed:

...
where:
a | _
3 | _
7 | _
0 | _

b << [5, 0, 0]

c = a > b ? a : b
