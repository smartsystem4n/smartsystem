package com.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Room;

@RestController
public class RoomController {
	
	@RequestMapping("/room/{id}")
	public Room room(@PathVariable String id) {
		return new Room();
	}
	
	@RequestMapping("/room/add")
	public String addRoom(@RequestBody Room room) {
		//return new Room();
		return null;
	}
	
	@RequestMapping("/room/update/{id}")
	public void updateRoom(@PathVariable String id, @RequestBody Room room) {
		//return new Room();
	}
	
	@RequestMapping("/room/delete/{id}")
	public void deleteRoom() {
		//return new Room();
	}
	
	@RequestMapping("/rooms")
	public List<Room> rooms() {
		//return new Room();
		return null;
	}
}
