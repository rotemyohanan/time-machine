
package com...interaction.db.config

import com.myOrg.myTeam.context.ReloadableConfig
import org.grails.datastore.mapping.mongo.MongoDatastore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by galba on 08/02/2017.
 */
@Configuration
@EnableMongoAuditing()
@EnableMongoRepositories(value = "com.myOrg.myTeam.interaction.db.repositories", mongoTemplateRef = "myTeamMongoTemplate")
class MongoDatasourceConfig {

    @Autowired
    MongoDatastore mongoDatastore

    @Autowired
    ReloadableConfig config

    @Bean
    MongoTemplate myOrgMongoTemplate() {
        String databaseName = config.getString("mongodb.databaseName")
        return new MongoTemplate(mongoDatastore.getMongoClient(), databaseName)
    }

}
