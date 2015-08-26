package com.chmapbrains.smart.system.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chmapbrains.smart.system.component.Switch;

/**
 * Servlet implementation class ExecCommand
 */
@WebServlet("/ExecCommand")
public class ExecCommand extends HttpServlet {
	private static final String EXE_CMD = "sudo /home/pi/apache-tomcat-8.0.22/control-io-pin-using-args ";
	private static final long serialVersionUID = 1L;
	private static final String ON = "ON" ;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecCommand() {
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
		synchronized (this) {
			
			String pin = request.getParameter("pin");
			String isOn = request.getParameter("isOn");
			System.out.println("pin = " + pin + " isOn = " + isOn + "command = " + EXE_CMD + pin + " " + isOn) ;
			Runtime.getRuntime().exec(EXE_CMD + pin + " " + isOn);	
			for(Switch swtch : SwitchInfo.getSwitches())
			{
				if(swtch.getPinNumber().equals(pin))
				{
					swtch.setOn(ON.equals(isOn));
					break ;
				}
			}
		}
		
	}
}
