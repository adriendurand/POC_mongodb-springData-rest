package com.adrien.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.adrien.poc.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "myLibrary";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
	}

	/**
	 * This method allow to create a custom converter
	 */
	@Bean
	@Override
	public MappingMongoConverter mappingMongoConverter() throws Exception {
		// avoid to add a property _class in the document
		MappingMongoConverter mmc = super.mappingMongoConverter();
		mmc.setTypeMapper(new DefaultMongoTypeMapper(null));
		return mmc;
	}

}
