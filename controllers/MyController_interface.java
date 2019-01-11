/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllers;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *	Author: Katie Markham 1/6/18
 *	Defining Joysticks for easy exchange
 *	Any new controller added should implement this interface.
 */
public interface MyController_interface {

	int getNumberofSticks();
	GenericHID getJoystick();
	JoystickButton b1();
	JoystickButton b2();
	JoystickButton b3();	
	JoystickButton b4();
	JoystickButton b5();	
	JoystickButton b6();	
	JoystickButton b7();	
	JoystickButton b8();
	JoystickButton b9();
	JoystickButton b10();
	JoystickButton b11();
	JoystickButton b12();
	Double DriveRotation();
	Double DriveX();
	Double DriveY();
	Double DriveThrottle();
	boolean Breaks();	
	void NotifyJoy();
}

/*
 * An interface sets up a contract or template for classes. 
 * In this case we want to be sure that any controller has the methods above defined 
 * so that they will all work with our commands and subsystems. 
 * 
 * Any changes to button configurations for an individual controller must be made in
 * the class for that controller type. 
 * 
 * https://www.tutorialspoint.com/java/java_interfaces.htm (read the whole thing for more info)
 * An interface cannot contain instance fields. 
 * The only fields that can appear in an interface must be declared both static and final. 
 * 
 * An interface is not extended by a class; it is implemented by a class.
 * 
 * An interface is implicitly abstract. 
 * You do not need to use the abstract keyword while declaring an interface.
 * 
 * Each method in an interface is also implicitly abstract, 
 * so the abstract keyword is not needed.
 * 
 * Methods in an interface are implicitly public.
 */

