package com.example.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class TempApplication {
//	@Bean
//	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {
//
//		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
//		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
//
//		return mongoTemplate;
//
//	}
	public static void main(String[] args) {
		run(TempApplication.class, args);
	}

}
