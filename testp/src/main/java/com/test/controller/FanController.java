package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Fan;

@RestController
public class FanController {

	@RequestMapping("/fan/{id}")
	public Fan fan(@PathVariable(value = "id") String id) {
		return new Fan();
	}

	@RequestMapping("/fan/add")
	public String addFan(@RequestBody Fan fan) {
		// return new Room();
		return "";
	}

	@RequestMapping("/fan/update/{id}")
	public void updateFan(@PathVariable String id, @RequestBody Fan fan) {
		// return new Room();
	}

	@RequestMapping("/fan/delete/{id}")
	public void deleteFan() {
		// return new Rom();
	}

	@RequestMapping("/fans")
	public List<Fan> fans() {
		List<Fan> fans = new ArrayList<Fan>();
		fans.add(new Fan());
		fans.add(new Fan());		
		return fans;
	}
	
	@RequestMapping("/fan/updatestate/{id}/{state}")
	public void updateState(@PathVariable String id, @PathVariable String state) {
		// return new Room();
	}
	
	@RequestMapping("/fan/updatestate/{state}")
	public void updateState(@PathVariable String state) {
		// return new Room();
	}
	
	@RequestMapping("/fan/updatemode/{id}/{state}")
	public void updateMode(@PathVariable String id, @PathVariable String state) {
		// return new Room();
	}
	
	@RequestMapping("/fan/updatemode/{mode}")
	public void updateMode(@PathVariable String mode) {
		// return new Room();
	}
}