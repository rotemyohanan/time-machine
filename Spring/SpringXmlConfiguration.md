

 - Seperation of concern



### ApplicationContext.xml

This is a root XML file.
(Convention over configuration.)
it is a sort of HashMap inside of the Application.
That can be a registry to the application.
XML configuration begins with this file.

under the **src.main.resources.applicationXontext.xml**

This is a Spring configuration file.

namespaces:
Spring namespaces is like a dictionary.

### XML declaration

    <bean  name="customerService" class="com.service.CustomerServiceImpl" autowire="byName">
        <property name="0 ref="customerRepository"/>
    </bean>
