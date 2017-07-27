### AOP (Aspect oriented programming)

AOP provides a different way of thinking about code structure, compared to OOP or procedural
programming. 

AOP enables us to think about concerns (transaction management, logging, or failure monitoring) or aspects in our system. 

AOP enables us to capture the cross-cutting code in modules such as interceptors.


Popular AOP technologies: 
 - Spring (includes a proxy-based AOP framework). Does not require any special manipulation of class loaders
   and is portable between environments, including any application server. 
    using J2SE dynamic proxies (capable of proxying any number of interfaces) or CGLIB byte code
    generation (which allows proxying classes, as well as interfaces). 
    Spring AOP proxies maintain a chain of advice applying to each method, making it easy to apply services such as 
    transaction management to POJOs. 
    
The additional behavior is applied by a chain of advice (usually interceptors) maintained by an
AOP proxy, which wraps the POJO target object.
Spring AOP allows the proxying of interfaces or classes. 

**Declarative transaction management:** This is the most important out-of-the-box service supplied
with Spring. It's analogous to the value proposition of EJB container-managed transactions (CMT)
with the following big advantages:
 - It can be applied to any POJO.
 - It isn't tied to JTA, but can work with a variety of underlying transaction APIs (including JTA).
 - Thus it can work in a web container or standalone application using a single database, and
   doesn't require a full J2EE application server.
 - It supports additional semantics that minimize the need to depend on a proprietary transaction API to force rollback.

AOP is often used in applications to handle aspects such as:
 - Auditing: Applying a consistent auditing policy (for example, to updates on persistent objects.)
 - Exception handling: Applying a consistent exception handling policy, such as emailing an
administrator in the event of a particular set of exceptions being thrown by a business object.
 - Caching: An aspect can maintain a cache transparent to proxied objects and their callers, providing a
simple means of optimization.
 - Retrying: Attempting transparent recovery: for example, in the event of a failed remote invocation.
