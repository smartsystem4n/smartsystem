package com.test.dto.service;

import java.util.List;

public class FanServiceViewDTO {
	private String id;
	private String label;
	List<RoomFanViewDTO> roomFanView;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<RoomFanViewDTO> getRoomFanView() {
		return roomFanView;
	}

	public void setRoomFanView(List<RoomFanViewDTO> roomFanView) {
		this.roomFanView = roomFanView;
	}
}
