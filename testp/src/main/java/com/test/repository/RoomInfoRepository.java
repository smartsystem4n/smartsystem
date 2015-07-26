package com.test.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.entity.RoomInfo;

public interface RoomInfoRepository extends MongoRepository<RoomInfo, String> {
	
	List<RoomInfo> findByRoomId(String roomId);
	RoomInfo findByEntityId(String entityId);		
	List<RoomInfo> findByRoomIdAndEntityType(String roomId, String entityType);
}
