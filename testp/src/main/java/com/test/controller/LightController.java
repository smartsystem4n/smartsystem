package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Light;
import com.test.entity.State;
import com.test.repository.DummyRepository;
import com.test.repository.LightRepository;

@RestController
public class LightController {

	@Autowired
	private LightRepository lightRepository;
	
	@Autowired
	private DummyRepository dummyRepository;

	@RequestMapping("/light/{id}")
	public Light light(@PathVariable String id) {
		return lightRepository.findOne(id);
	}

	@RequestMapping("/light/add")
	public Light addLight(@RequestBody Light light) {
		return lightRepository.save(light);
	}

	@RequestMapping("/light/update/{id}")
	public void updateLight(@PathVariable String id, @RequestBody Light light) {
		// return new Room();
	}

	@RequestMapping("/light/delete/{id}")
	public void deleteLight(@PathVariable String id) {
		lightRepository.delete(id);
	}

	@RequestMapping("/lights")
	public List<Light> lights() {
		return lightRepository.findAll();
	}

	@RequestMapping("/light/updatestate/{id}/{state}")
	public Light updateState(@PathVariable String id, @PathVariable String state) {
		//Light light = 	.findOne(id);
		Light light = dummyRepository.getLight(id);
		if ("ON".equals(state)) {
			light.setState(State.ON);
		} else {
			light.setState(State.OFF);
		}
		
		return light;
		//return lightRepository.save(light);
	}

	@RequestMapping("/lights/updatestate/{state}")
	public List<Light> updateState(@PathVariable String state) {
		List<Light> lights = lightRepository.findAll();
		if (lights != null) {
			for (Light light : lights) {
				if ("ON".equals(state)) {
					light.setState(State.ON);
				} else {
					light.setState(State.OFF);
				}
			}
		}
		return lightRepository.save(lights);
	}
}