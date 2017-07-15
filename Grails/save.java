// ----------------  Grails ----------------- //

The save method informs the persistence context that an instance should be saved or updated.
b.save()
The object will not be persisted immediately unless the flush argume
b.save(flush: true)

Parameters:

validate (optional) - Set to false if validation should be skipped.
    
flush (optional) - When set to true flushes the persistence context, persisting the object immediately and updating the version column for optimistic locking.
    
insert (optional) - When set to true will force Hibernate to do a SQL INSERT; this is useful in certain situations (for example when using assigned ids) and Hibernate cannot detect whether to do an INSERT or an UPDATE

failOnError (optional) - When set to true the save method with throw a grails.validation.ValidationException if validation fails. This behavior may also be triggered by setting the grails.gorm.failOnError property in grails-app/conf/Config.groovy. If the Config property is set and the argument is passed to the method, the method argument will always take precedence. For more details about the config property and other GORM config options, see the GORM Configuration Options section of The User Guide.
    
deepValidate (optional) - Determines whether associations of the domain instance should also be validated, i.e. whether validation cascades. This is true by default - set to false to disable cascading validation.
