package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.room.RoomViewDTO;
import com.test.entity.Fan;
import com.test.entity.Light;
import com.test.entity.Room;
import com.test.helper.TestHelper;

@RestController
public class RoomViewController {

	@RequestMapping("view/room/{id}")
	public RoomViewDTO view(@PathVariable String id) {
		RoomViewDTO roomViewDTO = new RoomViewDTO();
		Room room = TestHelper.createRoom();
		roomViewDTO.setRoom(room);	
		
		List<Light> lights = new ArrayList<Light>();
		Light light = TestHelper.createLight();
		lights.add(light);
		
		List<Fan> fans = new ArrayList<Fan>();
		Fan fan = TestHelper.createFan();
		fans.add(fan);
		
		roomViewDTO.setLights(lights);
		roomViewDTO.setFans(fans);
		return roomViewDTO;
	}
	
	@RequestMapping("view/rooms")
	public List<RoomViewDTO> allRooms() {
		//return new RoomViewDTO();
		return null;
	}
}
