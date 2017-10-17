
The DispatcherServlet acts as front controller – receiving all incoming HTTP requests and processing them.


Passing the requests to the relevant component with the help of handler mappings.
**HandlerMapping** is an **interface** that defines a mapping between requests and handler objects. 
While Spring MVC framework provides some ready-made implementations, the interface can be implemented by developers to provide customized mapping strategy.

**BeanNameUrlHandlerMapping** is the default HandlerMapping implementation. 
**BeanNameUrlHandlerMapping** maps request URLs to beans with the same name.


    @Configuration
    public class BeanNameUrlHandlerMappingConfig {
        @Bean
        BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
           return new BeanNameUrlHandlerMapping();
        }
 
        @Bean("/beanNameUrl")
        public WelcomeController welcome() {
           return new WelcomeController();
        }
     }
     
     
Now all requests to **“/beanNameUrl”** will be forwarded by DispatcherServlet to “WelcomeController“. 


The following code tests this configuration and makes sure that the correct view name is returned:

    public class BeanNameMappingConfigTest {
    // ...
 
        @Test
        public void whenBeanNameMapping_thenMappedOK() {
            mockMvc.perform(get("/beanNameUrl"))
              .andExpect(status().isOk())
              .andExpect(view().name("welcome"));
        }
    }


### SimpleUrlHandlerMapping
-----
The SimpleUrlHandlerMapping is the most flexible HandlerMapping implementation.


Let’s map requests “/simpleUrlWelcome” and “/*/simpleUrlWelcome” to the “welcome” bean:

    @Configuration
    public class SimpleUrlHandlerMappingConfig {
 
        @Bean
        public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
            SimpleUrlHandlerMapping simpleUrlHandlerMapping
                = new SimpleUrlHandlerMapping();
         
            Map<String, Object> urlMap = new HashMap<>();
            urlMap.put("/simpleUrlWelcome", welcome());
            simpleUrlHandlerMapping.setUrlMap(urlMap);
         
            return simpleUrlHandlerMapping;
        }
 
        @Bean
        public WelcomeController welcome() {
            return new WelcomeController();
        }
    }
    


To get the control over which mapping is used, the priorities are set using setOrder(int order) method. This method takes one int parameter where lower value mean higher priority.



### Overview:
--------

##### What is execution chain of DispatcherServlet?

  1. Request is sent by client. It arrives to **DispatcherServlet** class which is Spring's default front controller.
  2. DispatcherServlet uses request handler mapping to discover the controller which will analyze the request. The    implementations of 
     
     org.springframework.web.servlet.HandlerMapping // return an instance of org.springframework.web.servlet.HandlerExecutionChain class. This instance contains the array of handler interceptors which can be invoked before or after controller call. You can learn more about interceptors in article about handler interceptors in Spring. If no HandlerExecutionChain is found in all defined handler mappings, it means that Spring wasn't able to match URL with corresponding controllers. An error is thrown at this occasion.
Now the system applies pre-interceptors and calls the controller found by handler mapping. After asking the controller to handle the request, DispatcherServlet applies all defined post-interceptors. At the end of this step, it receives ModelAndView instance from controller.
DispatcherServlet uses now the view's name and sends it into view resolver. This resolver will decide what client should see exactly on the screen. Next, it returns this view to DispatcherServlet which can, at this moment, apply interceptors defined as "callable after view generation".
The last operation is the view's rendering as a response to initial client's request.

