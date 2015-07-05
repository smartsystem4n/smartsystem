package com.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Light;
import com.test.entity.Room;

@RestController
public class LightController {

	@RequestMapping("/light/{id}")
	public Light light(@PathVariable String id) {
		return new Light();
	}

	@RequestMapping("/light/add")
	public String addLight(@RequestBody Light light) {
		// return new Room();
		return "";
	}

	@RequestMapping("/light/update/{id}")
	public void updateLight(@PathVariable String id, @RequestBody Light light) {
		// return new Room();
	}

	@RequestMapping("/light/delete/{id}")
	public void deleteLight() {
		// return new Room();
	}

	@RequestMapping("/lights")
	public List<Light> lights() {
		// return new Room();
		return null;
	}
	
	@RequestMapping("/light/updatestate/{id}/{state}")
	public void updateState(@PathVariable String id, @PathVariable String state) {
		// return new Room();
	}
	
	@RequestMapping("/light/updatestate/{state}")
	public void updateState(@PathVariable String state) {
		// return new Room();
	}
}
