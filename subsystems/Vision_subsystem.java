/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
/**
 * Author: Katie Markham
 * Date: 1-13-19
 * Setting up basic camera functions
 */
public class Vision_subsystem extends Subsystem {
    // An object that generates images is a source
    // An object that accepts/consumes images is a sink
  private static UsbCamera cam1;
  private static UsbCamera cam2;
  private boolean cam1Active = true;
  private boolean cam1Offline = false;
  private boolean cam2Offline = false;
  
  public void init(){
      getCam1();
  }

  //return camera 1- for setting resolution, fps
  public UsbCamera getCam1(){ 
    cam1.setResolution(RobotMap.cam1XRes, RobotMap.cam1YRes);
    cam1.setFPS(RobotMap.cam1Fps);
    try{
      cam1Active = true; 
      cam1 = CameraServer.getInstance().startAutomaticCapture(RobotMap.cam1USB);
      return cam1; 
    } 
    catch(Exception e){
      cam1Offline = true;
      cam1Active = false;
      if(cam2Offline != true){
         return getCam2();
      }
      else 
      return null;
    }  
  }
  
  //return camera 2 - unless offline
  public UsbCamera getCam2(){ 
    cam2.setResolution(RobotMap.cam2XRes, RobotMap.cam2YRes);
    cam2.setFPS(RobotMap.cam2Fps);
    try{ 
      cam1Active = false;  
      cam2 = CameraServer.getInstance().startAutomaticCapture(RobotMap.cam2USB);
      return cam2; 
    }
    catch(Exception e){
      cam2Offline = true;
      System.out.println("Camera 2 Offline");
      if(cam1Offline != true){
        cam1Active = true;
        return getCam1();
      }
      else 
      return null;
    }
  }

  public boolean getCam1Offline(){
    return cam1Offline;
  }

  public boolean getCam2Offline(){
    return cam2Offline;
  }

  /**
	 * Swaps to chosen camera streaming to GRIP / SmartDashboard 
	 */
	public void toggleCameras() {
    if(cam1Active == true && cam2Offline!=true){
      getCam2();
    }
    else{
      if(cam1Offline != true){getCam1();}      
    }
  }

  public void resetCameras(){
    cam1Offline = false;
    cam2Offline = false;
    getCam1();
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  

}
