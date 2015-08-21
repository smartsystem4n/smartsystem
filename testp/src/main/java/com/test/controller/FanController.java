package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Fan;
import com.test.entity.State;
import com.test.repository.DummyRepository;
import com.test.repository.FanRepository;

@RestController
public class FanController {

	@Autowired
	private FanRepository fanRepository;
	
	@Autowired
	private DummyRepository dummyRepository;

	@RequestMapping("/fan/{id}")
	public Fan fan(@PathVariable(value = "id") String id) {
		return fanRepository.findOne(id);
	}

	@RequestMapping("/fan/add")
	public Fan addFan(@RequestBody Fan fan) {
		return fanRepository.save(fan);
	}

	/*
	 * @RequestMapping("/fan/update/{id}") public void updateFan(@PathVariable
	 * String id, @RequestBody Fan fan) { // return new Room(); }
	 */
	@RequestMapping("/fan/delete/{id}")
	public void deleteFan(@PathVariable(value = "id") String id) {
		fanRepository.delete(id);
	}

	@RequestMapping("/fans")
	public List<Fan> fans() {
		return fanRepository.findAll();
	}

	@RequestMapping("/fan/updatestate/{id}/{state}")
	public Fan updateState(@PathVariable String id, @PathVariable String state) {
		//Fan fan = fanRepository.findOne(id);
		Fan fan = dummyRepository.getFan(id);
		if ("ON".equals(state)) {
			fan.setState(State.ON);
		} else {
			fan.setState(State.OFF);
		}
		return fan;
		//return fanRepository.save(fan);
	}

	@RequestMapping("/fan/updatestate/{state}")
	public List<Fan> updateState(@PathVariable String state) {
		List<Fan> fans = fanRepository.findAll();
		if (fans != null) {
			for (Fan fan : fans) {
				if ("ON".equals(state)) {
					fan.setState(State.ON);
				} else {
					fan.setState(State.OFF);
				}
				fanRepository.save(fan);
			}
		}
		return fans;
	}

	/*
	 * @RequestMapping("/fan/updatemode/{id}/{state}") public void
	 * updateMode(@PathVariable String id, @PathVariable String state) { //
	 * return new Room(); }
	 * 
	 * @RequestMapping("/fan/updatemode/{mode}") public void
	 * updateMode(@PathVariable String mode) { // return new Room(); }
	 */
}