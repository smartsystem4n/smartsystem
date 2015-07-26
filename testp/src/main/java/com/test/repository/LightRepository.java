package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.entity.Light;

public interface LightRepository extends MongoRepository<Light, String> {

}