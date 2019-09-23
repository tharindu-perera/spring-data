package com.example.temp;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
 import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.core.query.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface PetsRepository extends MongoRepository<Pets, String> {

    Pets findBy_id(ObjectId _id);

    Pets findFirstByName(String name);

    @org.springframework.data.mongodb.repository.Query("{name:'Liam1'}")
    Pets mycustom(String name);
}


@Repository
class MyRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    Pets mycustom2(String name) {

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        query.limit(1);
        Pets maxObject = mongoTemplate.findOne(query, Pets.class);
        return maxObject;
    }
}