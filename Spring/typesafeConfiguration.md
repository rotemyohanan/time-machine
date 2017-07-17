

@ConfigurationProperties

Annotate with @configurationProperties

turns all of your application configuration into typesafe POJOs


@Component annotation - add the configuration in the component scan
@EnableconfigurationProperties(MyConfig.class) // 

    @Inject
    private MyConfig config;
