package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Room;
import com.test.repository.RoomRepository;

@RestController
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;

	@RequestMapping("/room/{id}")
	public Room room(@PathVariable String id) {
		return roomRepository.findOne(id);		
	}

	@RequestMapping("/room/add")
	public Room addRoom(@RequestBody Room room) {		
		return roomRepository.save(room);
	}

	@RequestMapping("/room/update/{id}")
	public Room updateRoom(@PathVariable String id, @RequestBody Room room) {
		return roomRepository.save(room);
	}

	@RequestMapping("/room/delete/{id}")
	public void deleteRoom(@PathVariable String id) {
		roomRepository.delete(id);
	}

	@RequestMapping("/rooms")
	public List<Room> rooms() {
		return roomRepository.findAll();
	}
}
