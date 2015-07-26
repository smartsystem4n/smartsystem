package com.test.dto.room;

import java.util.List;

import com.test.entity.Fan;
import com.test.entity.Light;
import com.test.entity.Room;

public class RoomViewDTO {	
	private Room room;
	private List<Light> lights;
	private List<Fan> fans;
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
	public List<Fan> getFans() {
		return fans;
	}
	public void setFans(List<Fan> fans) {
		this.fans = fans;
	}
}