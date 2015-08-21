package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.RoomInfo;
import com.test.repository.RoomInfoRepository;

@RestController
public class RoomInfoController {

	@Autowired
	private RoomInfoRepository roomInfoRepository;

	@RequestMapping("/roominfo/{id}")
	public RoomInfo roomInfo(@PathVariable String id) {
		return roomInfoRepository.findOne(id);
	}

	@RequestMapping("/roominfo/add")
	public RoomInfo addRoomInfo(@RequestBody RoomInfo roomInfo) {
		return roomInfoRepository.save(roomInfo);
	}

	/*
	 * @RequestMapping("/roominfo/update/{id}") public void
	 * updateLight(@PathVariable String id, @RequestBody Light light) { //
	 * return new Room(); }
	 */

	@RequestMapping("/roominfo/delete/{id}")
	public void deleteRoomInfo(@PathVariable String id) {
		roomInfoRepository.delete(id);
	}

	@RequestMapping("/roominfo/room/{roomId}")
	public List<RoomInfo> findEntity(@PathVariable String roomId) {
		return roomInfoRepository.findByRoomId(roomId);
	}

	@RequestMapping("/roominfo/entity/{entityId}")
	public RoomInfo findRoom(@PathVariable String entityId) {
		return roomInfoRepository.findByEntityId(entityId);
	}
	
	@RequestMapping("/roominfo/room/{roomId}/{entityType}")
	public List<RoomInfo> findRoom(@PathVariable String roomId, @PathVariable String entityType) {
		return roomInfoRepository.findByRoomIdAndEntityType(roomId, entityType);
	}	
}