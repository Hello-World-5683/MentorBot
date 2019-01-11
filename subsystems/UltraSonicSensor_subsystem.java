/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Author: Katie Markham
 * UltraSonicSensor:
 * Range is 6 inches to 254 inches inclusive
 * Connected to 5V supply. A supply of 5V yields ~9.8mV/in
*/
//TODO: Make Command, Add to Robot.java
//TODO: Test Sensor
public class UltraSonicSensor_subsystem extends Subsystem {
	public static final double SCALING = .0098; // Vcc/in  = (5/512)/in
    private AnalogInput SonicSensor = new AnalogInput(RobotMap.sonicsensor);
    
    /*
     * To get the distance you multiply the analog voltage 
     * by the sensitivity or scale factor (typically in inches/V or inches/mV).
     * 
     */
    
	public double getDistance(){ // gets distance in inches
		double distance = 6.0; 
		if(getSSVoltage() > SCALING * 6.0){
			distance = getSSVoltage()/SCALING; 
			if(distance > 254.0){distance=254.0;} //catch out of range dist
		}
		return distance;		
	}
    
	public Double getSSVoltage(){
		return SonicSensor.getVoltage(); //
	}
	
    public void initDefaultCommand() {
        // not needed
    	
    	// TODO: Investigate: Can robot only have one default command?
    }
}
