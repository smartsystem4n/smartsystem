package com.test.entity;

public class Fan extends Entity
{

	private int		pin2;
	private int		pin3;
	private int		pin4;
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

	public int getPin2()
	{
		return pin2;
	}

	public void setPin2(int pin2)
	{
		this.pin2 = pin2;
	}

	public int getPin3()
	{
		return pin3;
	}

	public void setPin3(int pin3)
	{
		this.pin3 = pin3;
	}

	public int getPin4()
	{
		return pin4;
	}

	public void setPin4(int pin4)
	{
		this.pin4 = pin4;
	}

}
