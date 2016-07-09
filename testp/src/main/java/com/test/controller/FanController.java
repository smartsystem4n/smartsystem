package com.test.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Fan;
import com.test.entity.Mode;
import com.test.entity.State;
import com.test.repository.DummyRepository;
import com.test.repository.FanRepository;

@RestController
public class FanController {
	private static final String EXE_CMD = "sudo /home/pi/GPIO/wiringPiGPIO ";
	private static final String EXE_FAN_CMD = "sudo /home/pi/GPIO/wiringPiGPIO ";
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
			System.out.println("pin = " + fan.getPinNo() + " isOn = " + "ON" + "command = " + EXE_CMD + fan.getPinNo() + " " + "ON") ;
			
			/*try {
				Runtime.getRuntime().exec(EXE_CMD + fan.getPinNo() + " " + "ON");		
				updateFanSpped(fan);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			updateFanSpped(fan);
		} else {
			fan.setState(State.OFF);
			System.out.println("pin = " + fan.getPinNo() + " isOn = " + "OFF" + "command = " + EXE_CMD + fan.getPinNo() + " " + "OFF") ;
			/*try {
				Runtime.getRuntime().exec(EXE_CMD + fan.getPinNo() + " " + "OFF");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			updateFanSpped(fan);
		}
		return fan;
		//return fanRepository.save(fan);
	}
	
	@RequestMapping("/fan/updatespeed/{id}/{speed}")
	public Fan updateFanSpeed(@PathVariable String id, @PathVariable String speed) {
		//Fan fan = fanRepository.findOne(id);
		Fan fan = dummyRepository.getFan(id);
		System.out.println("in fan speed contoller ");
		if("1".equals(speed))
		{
			System.out.println("speed 1");
			fan.setMode(Mode.ONE);
		}
		else if("2".equals(speed))
		{
			System.out.println("speed 2");
			fan.setMode(Mode.TWO);
		}
		else if("3".equals(speed))
		{
			System.out.println("speed 3");
			fan.setMode(Mode.THREE);
		}
		else if("4".equals(speed))
		{
			System.out.println("speed 4");
			fan.setMode(Mode.FOUR);
		}
		updateFanSpped(fan);
		return fan;
		//return fanRepository.save(fan);
	}

	/**
	 * @param fan
	 */
	private void updateFanSpped(Fan fan)
	{
		if (State.ON.equals(fan.getState())) {
			if(fan.getMode().equals(Mode.ONE))
			{
				System.out.println("pin = " + fan.getPinNo() + " isOn = " + "ON" + "command = " + EXE_CMD + fan.getPinNo() + " " + "ON") ;
				try 
				{
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPinNo() + " " + "OFF");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin2() + " " + "ON");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin3() + " " + "OFF");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin4() + " " + "OFF");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fan.getMode().equals(Mode.TWO))
			{
				System.out.println("pin = " + fan.getPinNo() + " isOn = " + "ON" + "command = " + EXE_CMD + fan.getPinNo() + " " + "ON") ;
				try 
				{
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPinNo() + " " + "ON");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin2() + " " + "OFF");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin3() + " " + "OFF");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin4() + " " + "OFF");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fan.getMode().equals(Mode.THREE))
			{
				System.out.println("pin = " + fan.getPinNo() + " isOn = " + "ON" + "command = " + EXE_CMD + fan.getPinNo() + " " + "ON") ;
				try 
				{
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPinNo() + " " + "ON");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin2() + " " + "ON");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin3() + " " + "OFF");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin4() + " " + "OFF");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fan.getMode().equals(Mode.FOUR))
			{
				System.out.println("pin = " + fan.getPinNo() + " isOn = " + "ON" + "command = " + EXE_CMD + fan.getPinNo() + " " + "ON") ;
				try 
				{
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPinNo() + " " + "ON");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin2() + " " + "ON");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin3() + " " + "ON");
					Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin4() + " " + "ON");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
		{
			try 
			{
				Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPinNo() + " " + "OFF");
				Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin2() + " " + "OFF");
				Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin3() + " " + "OFF");
				Runtime.getRuntime().exec(EXE_FAN_CMD + fan.getPin4() + " " + "OFF");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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