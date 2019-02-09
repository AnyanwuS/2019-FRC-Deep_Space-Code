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

public class Drive extends Command {

  public Drive(){
    requires(Robot.dt);
    requires(Robot.pdp);
  }
  
  @Override
  protected void initialize(){
  }

  //Instances ArcadeDrive with controller input
  @Override
  protected void execute(){
    Robot.dt.ArcadeDrive(OI.driver.getRawAxis(OI.leftY), OI.driver.getRawAxis(OI.rightX));
    //Checks power draw and current voltage while the robot is driving
    System.out.println(Robot.pdp.getInfo().toString());
  }

  //Command runs indefinitely since there is usu no need to disable driving capability
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
