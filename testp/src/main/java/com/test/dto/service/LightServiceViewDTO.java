package com.test.dto.service;

import java.util.List;

public class LightServiceViewDTO {
	private String id;
	private String label;
	List<RoomLightViewDTO> roomLightView;
	
	
	
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
	public List<RoomLightViewDTO> getRoomLightView() {
		return roomLightView;
	}
	public void setRoomLightView(List<RoomLightViewDTO> roomLightView) {
		this.roomLightView = roomLightView;
	}	
}
