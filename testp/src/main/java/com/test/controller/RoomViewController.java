package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.room.RoomViewDTO;
import com.test.entity.Fan;
import com.test.entity.Light;
import com.test.entity.Room;
import com.test.entity.RoomInfo;
import com.test.repository.FanRepository;
import com.test.repository.LightRepository;
import com.test.repository.RoomInfoRepository;
import com.test.repository.RoomRepository;

@RestController
public class RoomViewController {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomInfoRepository roomInfoRepository;

	@Autowired
	private LightRepository lightRepository;

	@Autowired
	private FanRepository fanRepository;

	@RequestMapping("view/room/{id}")
	public RoomViewDTO view(@PathVariable String id) {
		RoomViewDTO roomViewDTO = new RoomViewDTO();
		List<Light> lights = new ArrayList<Light>();
		List<Fan> fans = new ArrayList<Fan>();
		Room room = roomRepository.findOne(id);
		roomViewDTO.setRoom(room);
		List<RoomInfo> roomInfos = roomInfoRepository.findByRoomId(id);
		if (roomInfos != null) {
			for (RoomInfo roomInfo : roomInfos) {
				if (roomInfo.getEntityType().equals("light")) {
					Light light = lightRepository.findOne(roomInfo.getEntityId());
					lights.add(light);
				} else if (roomInfo.getEntityType().equals("fan")) {
					Fan fan = fanRepository.findOne(roomInfo.getEntityId());
					fans.add(fan);
				}
			}
		}
		roomViewDTO.setLights(lights);
		roomViewDTO.setFans(fans);
		return roomViewDTO;
	}

	@RequestMapping("view/rooms")
	public List<RoomViewDTO> allRooms() {
		List<RoomViewDTO> roomViewDTOs = new ArrayList<RoomViewDTO>();
		List<Room> rooms = roomRepository.findAll();
		if (rooms != null) {
			for (Room room : rooms) {
				RoomViewDTO roomViewDTO = new RoomViewDTO();
				List<Light> lights = new ArrayList<Light>();
				List<Fan> fans = new ArrayList<Fan>();
				roomViewDTO.setRoom(room);
				List<RoomInfo> roomInfos = roomInfoRepository.findByRoomId(room.getId());
				if (roomInfos != null) {
					for (RoomInfo roomInfo : roomInfos) {
						if (roomInfo.getEntityType().equals("light")) {
							Light light = lightRepository.findOne(roomInfo.getEntityId());
							lights.add(light);
						} else if (roomInfo.getEntityType().equals("fan")) {
							Fan fan = fanRepository.findOne(roomInfo.getEntityId());
							fans.add(fan);
						}
					}
				}
				roomViewDTO.setLights(lights);
				roomViewDTO.setFans(fans);
				roomViewDTOs.add(roomViewDTO);
			}
		}
		return roomViewDTOs;
	}
}