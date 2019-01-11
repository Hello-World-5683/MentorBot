/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Author: Katie Markham
 * Setting up NavX (gyro) subsystem  
 *  
 * https://www.kauailabs.com/public_files/navx-mxp
 * /apidocs/java/com/kauailabs/navx/frc/AHRS.html
 * 
 * instructions for installing library:
 * https://pdocs.kauailabs.com/navx-mxp/software/roborio-libraries/java/
 */

//TODO: Make NavX Commands, Add to Robot.java
//TODO: Test Sensor

//TODO: Test System
public class NavX_subsystem extends Subsystem {
	private AHRS ahrs;
	
	//constructor
	public NavX_subsystem(){
		try {
			ahrs = new AHRS(SPI.Port.kMXP); //setting up SPI port for navx MXP
			ahrs.enableLogging(true);
		}
		catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}
	
	//gets angle as a float -180 to 180
	public float getAngle(){
		return ahrs.getYaw();
	}
	
	public void reset() {
        ahrs.reset();
    }

    public void zeroYaw() {
        ahrs.zeroYaw();
    }
	
	public void getNavxData(){
		//gets the values back from navx 
		SmartDashboard.putBoolean("IMU_Connected", ahrs.isConnected());
		SmartDashboard.putBoolean("IMU_IsCalibrating", ahrs.isCalibrating());
		SmartDashboard.putNumber("IMU_YawAngle", ahrs.getYaw());
		SmartDashboard.putNumber("IMU_Pitch", ahrs.getPitch());
		SmartDashboard.putNumber("IMU_Roll", ahrs.getRoll());
		//Fetches 6 Axis Data from MXP and prints to SmartDash
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}
