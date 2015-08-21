package com.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.room.RoomViewDTO;
import com.test.dto.service.FanServiceViewDTO;

@RestController
public class ServiceViewController {

	@RequestMapping("view/service/fan")
	public FanServiceViewDTO fanService() {
		FanServiceViewDTO fanServiceViewDTO = new FanServiceViewDTO();
		fanServiceViewDTO.setId("1");
		fanServiceViewDTO.setLabel("Fan service");
		
		return fanServiceViewDTO;
	}
	
	@RequestMapping("view/service/light")
	public List<RoomViewDTO> lightService() {
		//return new RoomViewDTO();
		return null;
	}
}

