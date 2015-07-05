package com.test.helper;

import com.test.entity.Fan;
import com.test.entity.Light;
import com.test.entity.Room;

public class TestHelper {
	
	public static Room createRoom() {
		Room room = new Room();
		room.setId("1");
		room.setLabel("Bed Room");
		room.setImagePath("test\\path");
		return room;
		}
	
	public static Light createLight() {
		Light light = new Light();
		light.setId("2");
		light.setLabel("Switch");
		light.setImagePath("test\\path");
		return light;
		}
	
	public static Fan createFan() {
		Fan fan = new Fan();
		fan.setId("1");
		fan.setLabel("Switch");
		fan.setImagePath("test\\path");
		return fan;
		}

}
