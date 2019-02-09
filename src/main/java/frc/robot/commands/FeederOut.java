/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FeederOut extends Command {

  private double exhaust;
  private boolean enabled = Robot.rl.enabled;

  public FeederOut(double exhaust){
    requires(Robot.rl);
    this.exhaust = -exhaust;
  }

  @Override
  protected void initialize(){
  }

  @Override
  protected void execute(){
    if (!enabled){ 
      Robot.rl.setMotor(this.exhaust);
      enabled = true;
    }else{
      Robot.rl.setMotor(0);
      enabled = false;
    }
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
