
Annotation

    @ConfigurationProperties

Turns all of your application configuration into typesafe POJOs


**@Component** add the configuration in the component scan
**@EnableconfigurationProperties(MyConfig.class)**  

    @Inject
    private MyConfig config;


Validate the code using annotations:

    @NotNull
    @Patten   //regexp
    @Max
    @Min
    @Digit
    
    
    configure third party calsses
