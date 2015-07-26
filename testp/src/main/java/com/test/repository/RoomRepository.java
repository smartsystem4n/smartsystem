package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.entity.Room;

public interface RoomRepository extends MongoRepository<Room, String> {

}
