package com.chmapbrains.smart.system.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chmapbrains.smart.system.component.Switch;

/**
 * Servlet implementation class SwitchInfo
 */
@WebServlet("/SwitchInfo")
public class SwitchInfo extends HttpServlet {
	private static final String SWITCH = "switch";
	private static final long serialVersionUID = 1L;
	private static final List<Switch> switches = new ArrayList<Switch>();

	static {
		Switch switch1 = new Switch();
		switches.add(switch1);
		switch1.setId(SWITCH + "1");
		switch1.setName(SWITCH + "1");
		switch1.setPinNumber("1");
		switch1.setOn(false);

		Switch switch2 = new Switch();
		switches.add(switch2);
		switch2.setId(SWITCH + "2");
		switch2.setName(SWITCH + "2");
		switch2.setPinNumber("2");
		switch2.setOn(false);

		Switch switch3 = new Switch();
		switches.add(switch3);
		switch3.setId(SWITCH + "3");
		switch3.setName(SWITCH + "3");
		switch3.setPinNumber("3");
		switch3.setOn(false);

		Switch switch4 = new Switch();
		switches.add(switch4);
		switch4.setId(SWITCH + "6");
		switch4.setName(SWITCH + "6");
		switch4.setPinNumber("6");
		switch4.setOn(false);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SwitchInfo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public static List<Switch> getSwitches() {
		return switches;
	}

}
