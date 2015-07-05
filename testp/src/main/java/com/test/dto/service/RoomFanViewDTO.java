package com.test.dto.service;

import java.util.List;

import com.test.entity.Fan;
import com.test.entity.Room;

public class RoomFanViewDTO {
	private Room room;
	private List<Fan> fans;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Fan> getFans() {
		return fans;
	}

	public void setFans(List<Fan> fans) {
		this.fans = fans;
	}
}
