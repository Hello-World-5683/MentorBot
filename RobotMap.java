/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 *	Author: Katie Markham
 *	Allows for system configuration changes in one place.
 *
 *	The RobotMap is a mapping Robot System
 *	Robot ports, sensors and actuators are wired into ports given variable names here. 
 *	(Easier to check wiring)
 *	 
 *	Extended original use to also map driver station inputs
 *
 *	If you are using multiple modules, make sure to define both the port
 *	number and the module. For example you with a rangefinder:
 *	public static int rangefinderPort=1;
 *	public static int rangefinderModule=1;
 **/

public class RobotMap {
	
//	Robot Mapping 
	// 	Wheel Motor Ports 
	public static int m1_frontLeft=0;
	public static int m2_frontRight=1;
	public static int m3_rearRight=2;
	public static int m4_rearLeft=3;
	
	// Wench Motor Port
	public static int m5_wMotor=4;
	
	// Sonic Sensor
	public static int sonicsensor = 0;

	
//	Driver Station Mapping
	// Joystick (Can be checked on driver station usb inputs)
	public static int joy1Port=0; 
	
	
// Constants
	public static final double SLOW = .4; //multiply stick values to slow speeds 
	public static final double NOTIFYLVL = .3; //Strength of notify controller via rumble where available

}
