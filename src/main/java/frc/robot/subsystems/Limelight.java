/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;;


/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public NetworkTable ll = NetworkTableInstance.getDefault().getTable("limelight");

  public NetworkTableEntry horizontalOffset = ll.getEntry("tx");
  public NetworkTableEntry verticalOffset = ll.getEntry("ty");
  public NetworkTableEntry targetArea = ll.getEntry("ta");
  public NetworkTableEntry skew = ll.getEntry("ts");
  public NetworkTableEntry led = ll.getEntry("ledMode");
  public NetworkTableEntry cameraMode = ll.getEntry("camMode");

  public double getHorizontalOffset(){
    return horizontalOffset.getDouble(0.0);
  }

  public double getVerticalOffset(){
    return verticalOffset.getDouble(0.0);
  }

  public double getTargetArea(){
    return targetArea.getDouble(0.0);
  }
  
  public double getSkew(){
    return skew.getDouble(0.0);
  }
  public void switchLED(int mode){
    switch (mode){
      case 1:
      led.setDouble(1);
      break;
    case 2:
      led.setDouble(2);
      break;
    case 3:
      led.setDouble(3);
      break;
    default:
      led.setDouble(0);
      break;
    }
    return;
  }
  public void camMode(int mode)
  {
    if(mode ==1){
      cameraMode.setDouble(1);
    } else {
      cameraMode.setDouble(0);
    }
    return;
  }

  public double rotatetoTarget(double PID)
  {
    double power;
    power = horizontalOffset.getDouble(0)*PID;
    return power;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
