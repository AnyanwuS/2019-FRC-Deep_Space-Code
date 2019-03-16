/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Command {
  
  public Drive(){
    requires(Robot.dt);
  }
  
  @Override
  protected void initialize(){
  }

  //Instances ArcadeDrive with controller input
  @Override
  protected void execute(){
    Robot.dt.ArcadeDrive(OI.driver.getRawAxis(OI.leftY), OI.driver.getRawAxis(OI.rightX));
    double[] currentVelocity = Robot.dt.encoderVelocity();
    //Put data into Smartdashboard
    SmartDashboard.putNumber("Left Encoder Velocity: ", currentVelocity[0]);
    SmartDashboard.putNumber("Right Encoder Velocity: ", currentVelocity[1]);
    Timer.delay(0.005);
  }

  @Override
  protected boolean isFinished(){
    return false;
  }

  @Override
  protected void end(){
  }

  @Override
  protected void interrupted(){
  }
}
