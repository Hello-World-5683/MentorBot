/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.MDwJoystick_command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
/**
 *	Author: Katie Markham
 *	Setting up Mecanum Drive Subsystem.
 */
public class Mecanum_subsystem extends Subsystem {
	private static boolean inverted = true;
	// class variables
	private static Victor V1_FL = new Victor(RobotMap.m1_frontLeft);
	private static Victor V2_FR = new Victor(RobotMap.m2_frontRight);
	private static Victor V3_BR = new Victor(RobotMap.m3_rearRight);
	private static Victor V4_BL = new Victor(RobotMap.m4_rearLeft);

	private static MecanumDrive MEC_DRIVE = new MecanumDrive(V1_FL, V2_FR, V3_BR, V4_BL);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new MDwJoystick_command());
    }
    
	public void mecanumDrive( double xSpeed, double ySpeed, double zRotation, double gyroAngle){
		
		if (inverted) {
			MEC_DRIVE.driveCartesian(-xSpeed, -ySpeed, zRotation, gyroAngle);
			} else {
			MEC_DRIVE.driveCartesian(xSpeed, ySpeed, zRotation, gyroAngle);		
			}//m_robotDrive.driveCartesian(m_stick.getX(), m_stick.getY(), m_stick.getZ(), 0.0);
	}
	
	public void engageMotorSafety(){
		MEC_DRIVE.setSafetyEnabled(true);
	}
	
	public void disableMotorSafety(){
		MEC_DRIVE.setSafetyEnabled(false);
	}
	
	/**
	 * Set not inverted
	 */
	public void setInvertedFalse() {
		inverted = false;
	}
	
	/**
	 * Set inverted true
	*/
	
	public void setInvertedTrue() {
		inverted = true;
	}
		
	public void stop(){
		MEC_DRIVE.driveCartesian(0, 0, 0, 0);
	}
	
}

