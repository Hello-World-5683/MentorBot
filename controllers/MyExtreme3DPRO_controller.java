/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllers;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *  Extreme3DPro Joystick
 *	Author: Katie Markham 1/6/18
 *	Defining Joysticks for easy exchange
 *	Super to OI class, implements MyController_interface
 */

public class MyExtreme3DPRO_controller implements MyController_interface{
	//TODO: Check mapping and test functionality	
	public static int XAxis=0;
	public static int YAxis=1;
	public static int ZRotate=2;
	public static int Slider=3;
	
	private static Joystick ExtremePro = new Joystick(RobotMap.joy1Port);
	private JoystickButton trigger = new JoystickButton(ExtremePro, 1); // Trigger
	private JoystickButton sidebutton = new JoystickButton(ExtremePro, 2); // Button on the side of trigger

	// top buttons
	private static JoystickButton b3 = new JoystickButton(ExtremePro, 3);
	private static JoystickButton b4 = new JoystickButton(ExtremePro, 4);
	private static JoystickButton b5 = new JoystickButton(ExtremePro, 5);
	private static JoystickButton b6 = new JoystickButton(ExtremePro, 6);

	//side buttons
	private static JoystickButton b7 = new JoystickButton(ExtremePro, 7);
	private static JoystickButton b8 = new JoystickButton(ExtremePro, 8);
	private static JoystickButton b9 = new JoystickButton(ExtremePro, 9);
	private static JoystickButton b10 = new JoystickButton(ExtremePro, 10);
	private static JoystickButton b11 = new JoystickButton(ExtremePro, 11);
	private static JoystickButton b12 = new JoystickButton(ExtremePro, 12);
	
	private static int num_of_sticks = 1;
	
	public MyExtreme3DPRO_controller(){
		ExtremePro.setThrottleChannel(Slider);
		ExtremePro.setTwistChannel(ZRotate);
		ExtremePro.setXChannel(XAxis);
		ExtremePro.setYChannel(YAxis);
	}
	
	@Override
	public int getNumberofSticks() {
		return num_of_sticks;
	}

	@Override
	public GenericHID getJoystick() {	
		return ExtremePro;
	}


	@Override
	public Double DriveRotation() {		
		return ExtremePro.getTwist();
	}

	@Override
	public Double DriveX() {
		return ExtremePro.getX();
	}

	@Override
	public Double DriveY() {
		return ExtremePro.getY();
	}

	@Override
	public void NotifyJoy() {
		//TODO: Check Rumble
		ExtremePro.setRumble(null, RobotMap.NOTIFYLVL);
	}
	
	// Returns the slow value if Drive throttle is not set higher (slider is throttle on this joystick)
	@Override
	public Double DriveThrottle() {
		if(ExtremePro.getThrottle() > RobotMap.SLOW){return ExtremePro.getThrottle();}
		return RobotMap.SLOW;
	}
	
	@Override
	public boolean Breaks() {
		//currently no breaks assigned to this joystick
		return false;
	}


	// Maps Extreme3DPRO Controller buttons to OI controlls
	// Change button returns to change function mapping 
	@Override
	public JoystickButton b1() {
		return trigger;
	}

	@Override
	public JoystickButton b2() {
		return sidebutton;
	}

	@Override
	public JoystickButton b3() {
		return b3;
	}

	@Override
	public JoystickButton b4() {
		return b4;
	}

	@Override
	public JoystickButton b5() {
		return b5;
	}

	@Override
	public JoystickButton b6() {
		return b6;
	}

	@Override
	public JoystickButton b7() {
		return b7;
	}

	@Override
	public JoystickButton b8() {
		return b8;
	}

	@Override
	public JoystickButton b9() {
		return b9;
	}

	@Override
	public JoystickButton b10() {
		return b10;
	}
	
	@Override
	public JoystickButton b11(){
		return b11;
	}
	
	@Override
	public JoystickButton b12(){
		return b12;
	}
}