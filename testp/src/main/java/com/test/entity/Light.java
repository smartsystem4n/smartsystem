package com.test.entity;

public class Light extends Entity {
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
