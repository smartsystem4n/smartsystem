package com.smart.system.entity;

public class Fan extends Entity
{

	private State	state;
	private Mode	mode;

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public Mode getMode()
	{
		return mode;
	}

	public void setMode(Mode mode)
	{
		this.mode = mode;
	}
}
