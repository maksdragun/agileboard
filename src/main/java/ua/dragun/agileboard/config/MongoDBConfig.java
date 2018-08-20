package ua.dragun.agileboard.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;
import java.util.Collections;

@Configuration
@ComponentScan(basePackages = "ua.dragun.agileboard")
public class MongoDBConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private Integer port;

    @Value("${spring.data.mongodb.database}")
    private String db;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.authenticationDB}")
    private String authDB;

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(
                new SimpleMongoDbFactory(
                        mongoClient(),
                        getDatabaseName()
                )
        );
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        MongoClient mongoClient = null;
        mongoClient = new MongoClient(
                new ServerAddress(host, port),
                Collections.singletonList(
                        MongoCredential.createMongoCRCredential(
                                username,
                                authDB,
                                password.toCharArray()
                        )
                )
        );
        return mongoClient;
    }

    @Override
    protected String getDatabaseName() {
        return db;
    }
}
