package com.test.entity;

public enum State {
	ON("ON"), OFF("OFF"), UNKNOWN("UNKNOWN");
	private String stateName;

	State(String stateName) {
		this.stateName = stateName;
	}

	public State getStatesdfdf(String stateName) {
		if ("ON".equals(stateName)) {
			return State.ON;
		} else if ("OFF".equals(stateName)) {
			return State.OFF;
		} else {
			return State.UNKNOWN;
		}
	}
}
