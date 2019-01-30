/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * Untested bare bones...
 * 
 * Elevator subsytem using : 
 * TalonSRX MotorController, VersaPlanetary Integrated Encoder,
 * Motor??******* Fill in details
 *  
 * Configuration instructions: @link
 * https://phoenix-documentation.readthedocs.io/en/
 * latest/ch16_ClosedLoop.html#motion-magic-position-
 * velocity-current-closed-loop-closed-loop
 * 
 * Position or MotionMagic looks like our best bet
 */
public class Elevator_subsystem extends Subsystem {

/*
* --- [1] Update CAN Device IDs and use WPI_VictorSPX where necessary ------
*/
  //WPI_TalonSRX example = new WPI_TalonSRX(deviceNumber)
  private static WPI_TalonSRX _elevatorMotor = new WPI_TalonSRX(RobotMap.m5_wMotor);

  //Use in commands (set target rotations)
  public void moveToTarget(double speed, double rotations){
    //speed * ticks/rev * rotations
    //4096 full rotation
    double targetPos = speed * 4096 * rotations;
    _elevatorMotor.set(ControlMode.MotionMagic, targetPos);
  }

  public Integer getPosition(){
    return _elevatorMotor.getSelectedSensorPosition();
  }

  public void resetPostion(){
    _elevatorMotor.setSelectedSensorPosition(0);
  }

  public void stop(){
    _elevatorMotor.stopMotor();
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
