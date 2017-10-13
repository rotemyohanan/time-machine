
The DispatcherServlet acts as front controller – receiving all incoming HTTP requests and processing them.

passing the requests to the relevant component with the help of handler mappings.
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


