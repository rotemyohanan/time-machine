

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


Beans: 
These are POJO classes.
Replace the keyword **new**
Define a class and use the Interface.

seperate configuration from the business logic - that helps use the same business logic in production and on development although the configuration is different.

This calls the seperation of concerns.

The beans are defined inside the **applicationContext.xml file**.

    <bean name="customerRepository class="com.repositoryImple"></bean>
    
Setter injection.


The Spring reduces the following:

no new object should be done in the code
no getters and setters in the class.


Calling to the ApplicationContext:

    ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    
(under the **src.main.resources**)

    Customerservice customerService = appContext.getBean("customerService", CustomerService.class);
    


@Autowire

Spring automatically wires Beans:
- **byType**
- **byName**
- **constructor** (similar to setter injection, indexed based)
- **no/none** for autowired


      <bean name="customerService" class="com.service.CustomerServiceImpl" autowire="constructor">
         <property name="0 ref="customerRepository"/>
      </bean>

Without the **autowire** we get a **NPE** when the application runs.



