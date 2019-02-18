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
  
  private int direction = 1;

  public Drive(int direction){
    requires(Robot.dt);
    this.direction = direction;
  }
  
  @Override
  protected void initialize(){
  }

  //Instances ArcadeDrive with controller input
  @Override
  protected void execute(){
    Robot.dt.ArcadeDrive(OI.driver.getRawAxis(OI.leftY)*direction, OI.driver.getRawAxis(OI.rightX));
  }

  @Override
  protected boolean isFinished(){
    return true;
  }

  @Override
  protected void end(){
  }

  @Override
  protected void interrupted(){
  }
}
