

 - Seperation of concern



### ApplicationContext.xml


This is a Spring configuration file (a root XML file.).
(Convention over configuration.)
it is a sort of HashMap inside of the Application.
That can be a registry to the application.
XML configuration begins with this file.

##### Location
Under the **src.main.resources.applicationXontext.xml**

##### namespaces

Spring namespaces is like a dictionary.

### XML declaration

    <bean  name="customerService" class="com.service.CustomerServiceImpl" autowire="byName">
        <property name="0 ref="customerRepository"/>
    </bean>


##### Beans
These are POJO classes.
Replace the keyword **new**
They define a class and use the Interface.

seperate configuration from the business logic - that helps use the same business logic in production and on development although the configuration is different. (this calls the seperation of concerns)

The beans are defined inside the **applicationContext.xml file**.

    <bean name="customerRepository class="com.repositoryImple"></bean>
    

##### The Spring reduces the following:
1. No new object should be done in the code.
2. No getters and setters in the class. (clean code)


#### Calling to the ApplicationContext:

    ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Customerservice customerService = appContext.getBean("customerService", CustomerService.class);
    


#### @Autowire

Spring automatically wires Beans:
- **byType**
- **byName**
- **constructor** (similar to setter injection, indexed based)
- **no/none** for autowired


      <bean name="customerService" class="com.service.CustomerServiceImpl" autowire="constructor">
         <property name="0 ref="customerRepository"/>
      </bean>

Without the **autowire** we get a **NPE** when the application runs.



