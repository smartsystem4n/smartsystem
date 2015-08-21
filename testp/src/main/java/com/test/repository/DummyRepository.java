package com.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.dto.room.RoomViewDTO;
import com.test.entity.Fan;
import com.test.entity.Light;
import com.test.entity.Room;
import com.test.entity.State;

@Component
public class DummyRepository {
	List<Room> rooms = new ArrayList<Room>();
	List<Light> lights = new ArrayList<Light>();
	List<Fan> fans = new ArrayList<Fan>();
	List<RoomViewDTO> roomViewDTOs = new ArrayList<RoomViewDTO>();

	DummyRepository() {
		Room room = new Room();
		List<Light> room1Lights = new ArrayList<Light>();
		List<Fan> room1Fans = new ArrayList<Fan>();
		room.setId("r1");
		room.setLabel("Living Room");
		room.setSequenceNo(1);
		rooms.add(room);

		Light light = new Light();
		light.setId("l1");
		light.setLabel("Light 1");
		light.setState(State.OFF);
		light.setSequenceNo(1);
		room1Lights.add(light);

		light = new Light();
		light.setId("l2");
		light.setLabel("Light 2");
		light.setState(State.OFF);
		light.setSequenceNo(2);
		room1Lights.add(light);
		
		Fan fan = new Fan();
		fan.setId("f1");
		fan.setLabel("Fan");
		fan.setState(State.OFF);
		fan.setSequenceNo(2);
		room1Fans.add(fan);

		RoomViewDTO roomViewDTO = new RoomViewDTO();
		roomViewDTO.setRoom(room);
		roomViewDTO.setLights(room1Lights);
		roomViewDTO.setFans(room1Fans);
		roomViewDTOs.add(roomViewDTO);
		
		lights.addAll(room1Lights);
		fans.addAll(room1Fans);
		
		//room2
		room = new Room();
		List<Light> room2Lights = new ArrayList<Light>();
		List<Fan> room2Fans = new ArrayList<Fan>();
		room.setId("r2");
		room.setLabel("Master Bed Room");
		room.setSequenceNo(2);
		rooms.add(room);

		light = new Light();
		light.setId("l3");
		light.setLabel("Light 1");
		light.setState(State.OFF);
		light.setSequenceNo(1);
		room2Lights.add(light);

		light = new Light();
		light.setId("l4");
		light.setLabel("Light 2");
		light.setState(State.OFF);
		light.setSequenceNo(2);
		room2Lights.add(light);

		roomViewDTO = new RoomViewDTO();
		roomViewDTO.setRoom(room);
		roomViewDTO.setLights(room2Lights);
		roomViewDTO.setFans(room2Fans);
		roomViewDTOs.add(roomViewDTO);
		
		lights.addAll(room2Lights);
		fans.addAll(room2Fans);

	}

	public List<RoomViewDTO> getRoomViewDTOs() {

		return roomViewDTOs;
	}

	public Light getLight(String id) {
		
		for (Light light : lights) {
			if (light.getId().equals(id)) {
				return light;
			}
			
		}
		return null;
	}

	public Fan getFan(String id) {		
		for (Fan fan : fans) {
			if (fan.getId().equals(id)) {
				return fan;
			}
			
		}
		return null;
	}
	
	public static void main(String[] s) {
		DummyRepository dummyRepository = new DummyRepository();
		List<RoomViewDTO> mm= dummyRepository.getRoomViewDTOs();
		System.out.println();
	}
}
