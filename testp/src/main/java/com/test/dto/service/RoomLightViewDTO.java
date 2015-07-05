package com.test.dto.service;

import java.util.List;

import com.test.entity.Light;
import com.test.entity.Room;

public class RoomLightViewDTO {
	private Room room;
	private List<Light> lights;
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public List<Light> getLights() {
		return lights;
	}
	public void setLights(List<Light> lights) {
		this.lights = lights;
	}	
}
