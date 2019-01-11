/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Author: Katie Markham
 * Basic Mecanum Drive with Joystick
 */
public class MDwJoystick_command extends Command {
	// constructor, declare subsystem dependencies
    public MDwJoystick_command() {      
    	requires(Robot.MD);   	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.MD.engageMotorSafety();
    	Robot.MD.mecanumDrive(
    			Robot.m_oi.DriveX()* throttle(), //xSpeed
    			Robot.m_oi.DriveY()* throttle(), //ySpeed
    			Robot.m_oi.DriveRotation()* throttle(), //zRotation
    			0.0//gyroAngle
    	); 
    }

    //TODO: Find source for throttle equation... Move to controllers?
    protected Double throttle(){
    	Double throttle = (-Robot.m_oi.DriveThrottle()+ 1)/2 * 0.9;
    	return throttle;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.MD.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
