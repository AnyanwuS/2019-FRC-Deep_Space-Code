/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CV_Belt extends Command {

  private double power = 0.0;

  public CV_Belt(double power){
    requires(Robot.cv);
    this.power = power;
  }

  @Override
  protected void initialize(){
  }

  @Override 
  protected void execute(){
    Robot.cv.setPower(power);
  }

  @Override
  protected boolean isFinished(){
    return false;
  }

  @Override 
  protected void end(){
    Robot.cv.stop();
  }

  @Override
  protected void interrupted(){
    end();
  }
}

