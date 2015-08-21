package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.entity.Fan;

public interface FanRepository extends MongoRepository<Fan, String> {

}
