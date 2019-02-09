/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArgonPusher extends Command {

  private boolean ps = Robot.op.pushState;

  public ArgonPusher(){
      requires(Robot.op);
  }

  @Override
  protected void initialize(){
  }

  @Override 
  public void execute(){
    //addSequential(new shiftPiston(true));
    if (!ps){
      Robot.op.shiftPiston(true);
      ps = true;
    }else{
      Robot.op.shiftPiston(false);
      ps = false;
    }
  }

  @Override
  protected boolean isFinished(){
    return true;
  }

  @Override 
  public void end(){
  }

  @Override 
  protected void interrupted(){
  }
}

