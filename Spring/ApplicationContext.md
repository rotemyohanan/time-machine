## Application Context

The **ApplicationContext** is the central interface within a Spring application for providing configuration information to the application.
It is read-only at run time, but can be reloaded. 
A number of classes implement the ApplicationContext interface, allowing for a variety of configuration options and types of applications.

#### The ApplicationContext provides:
--------

1) Bean factory methods for accessing application components.
2) The ability to load file resources in a generic fashion.
3) The ability to publish events to registered listeners.
4) The ability to resolve messages to support internationalization.
5) Inheritance from a parent context.



All incoming requests flow through a DispatcherServlet. 
Load this Servlet at web app startup time via an in the web app’s **WEB-INF/web.xml**. 
The **DispatcherServlet** is also responsible for loading a Spring **ApplicationContext** that is used to perform wiring and 
dependency injection of managed component. 
