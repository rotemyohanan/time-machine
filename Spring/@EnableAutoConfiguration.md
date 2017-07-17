

    @EnableAutoConfiguration

    @Import(EnableAutoConfigurationImportSelector.class)
    
    SpringFactoriesLoader.loadFactoryNames(...)
    
    /META-INF/spring.factories    // this is a properties file
    
    the **META-INF** is under the **Resources** add the spring.factories file
