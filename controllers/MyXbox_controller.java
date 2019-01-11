/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllers;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *	Author: Katie Markham 1/6/18
 *	Defining Joysticks for easy exchange
 *	Super to OI class, implements MyController_interface
 */
public class MyXbox_controller implements MyController_interface {
	/*
	 * Map of ports (from drivers station) isn't used but may be useful as reference.
	 * 
	 * private int XAxisLeft = 0;
	 * private int YAxisLeft = 1; 
	 * private int TriggerAxisLeft = 2;
	 * private int TriggerAxisRight= 3;	
	 * private int XAxisRight = 4;	
	 * private int YAxisRight = 5;	
	 *   
	 */
	
	// Physical button map
	private static XboxController XBox1 = new XboxController(RobotMap.joy1Port);
	private static JoystickButton A = new JoystickButton(XBox1, 1); // A
	private static JoystickButton B = new JoystickButton(XBox1, 2); // B
	private static JoystickButton X = new JoystickButton(XBox1, 3); // X
	private static JoystickButton Y = new JoystickButton(XBox1, 4); // Y
	private static JoystickButton LB = new JoystickButton(XBox1, 5); // Button above LTrigger
	private static JoystickButton RB = new JoystickButton(XBox1, 6); // Button above RTrigger
	private static JoystickButton Back = new JoystickButton(XBox1, 7); // Back
	private static JoystickButton Start = new JoystickButton(XBox1, 8); // Start
	private static JoystickButton LS = new JoystickButton(XBox1, 9); // Left Stick Button
	private static JoystickButton RS = new JoystickButton(XBox1, 10); // Right Stick Button
	private static JoystickButton b11 = new JoystickButton(XBox1, 11);
	private static JoystickButton b12 = new JoystickButton(XBox1, 12);
	private int num_of_sticks = 2;
	
	@Override
	public XboxController getJoystick(){
		return XBox1;
	}
		
	@Override
	public int getNumberofSticks() {
		return num_of_sticks;
	}
	
	@Override
	public Double DriveRotation(){
		return getXRight(); // turn with right stick	
	}
	
	@Override
	public Double DriveThrottle(){
		if(getRTriggerAxis()>RobotMap.SLOW){
			return getRTriggerAxis();
		}
		return RobotMap.SLOW;
	}
	
	@Override
	public boolean Breaks(){
		if(getLTriggerAxis()>0){
			return true;
		}
		return false;
	}
	
	@Override
	public Double DriveX(){
		return getXLeft();
	}
	
	@Override
	public Double DriveY(){
		return getYLeft();
	}
	
	@Override
	public void NotifyJoy(){
		vibrateXboxController(RumbleType.kLeftRumble, RobotMap.NOTIFYLVL);
		vibrateXboxController(RumbleType.kLeftRumble, RobotMap.NOTIFYLVL);
	}
	
	



	// Maps Xbox Controller buttons to OI controlls
	// Change button returns to change function mapping 
	@Override
	public JoystickButton b1(){
		return A;
	}
	
	@Override
	public JoystickButton b2(){
		return B;
	}
	
	@Override
	public JoystickButton b3(){
		return X;
	}
	
	@Override
	public JoystickButton b4(){
		return Y;
	}
	
	@Override
	public JoystickButton b5(){
		return LB;
	}
	
	@Override
	public JoystickButton b6(){
		return RB;
	}
	
	@Override
	public JoystickButton b7(){
		return Back;
	}	
	
	@Override
	public JoystickButton b8(){
		return Start;
	}	
	
	@Override
	public JoystickButton b9(){
		return LS;
	}
	
	@Override
	public JoystickButton b10(){
		return RS;
	}
	
	@Override
	public JoystickButton b11(){
		return b11;
	}
	
	@Override
	public JoystickButton b12(){
		return b12;
	}

	// Return X-Axis Left Stick
	public Double getXLeft() {
		return XBox1.getX(Hand.kLeft); // Port 0
	}

	// Return Y-Axis Left Stick
	public Double getYLeft() {
		return XBox1.getY(Hand.kLeft); // Port 1
	}

	// Return Trigger Axis Left Hand
	public Double getLTriggerAxis() {
		return XBox1.getTriggerAxis(Hand.kLeft); // Port 2
	}

	// Return Trigger Axis Right Hand
	public Double getRTriggerAxis() {
		return XBox1.getTriggerAxis(Hand.kRight); // Port 3
	}

	// Return X-Axis Right Stick
	public Double getXRight() {
		return XBox1.getX(Hand.kRight); // Port 4
	}

	// Return Y-Axis Right Stick
	public Double getYRight() {
		return XBox1.getY(Hand.kRight); // Port 5
	}

	// Return true Left Trigger Pressed
	public boolean LTriggerPressed() {
		if (getLTriggerAxis() > 0) {
			return true;
		}
		return false;
	}

	public boolean RTriggerPressed() {
		if (getRTriggerAxis() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Set the vibration motors of the Xbox controller
	 * @param type  The motor to vibrate. Uses RumbleType constant kLeftRumble or
	 *              kRightRumble
	 * @param value The strength at which the motor vibrates in range [0, 1]
	 */

	public void vibrateXboxController(RumbleType type, double value) {
		XBox1.setRumble(type, value);
	}
}
