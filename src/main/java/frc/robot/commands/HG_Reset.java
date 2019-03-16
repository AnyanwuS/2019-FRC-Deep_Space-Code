/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class HG_Reset extends Command {

  public HG_Reset(){
      requires(Robot.hg);
  }

  @Override
  protected void initialize(){
  }

  @Override 
  public void execute(){
    Robot.hg.claw.set(DoubleSolenoid.Value.kReverse);
    Timer.delay(0.1);
    Robot.hg.initExtend.set(DoubleSolenoid.Value.kReverse);
    Timer.delay(0.1);
    Robot.hg.fullExtend.set(DoubleSolenoid.Value.kReverse);
    Timer.delay(0.1);
    Robot.hg.initExtend.set(DoubleSolenoid.Value.kOff);
    Robot.hg.fullExtend.set(DoubleSolenoid.Value.kOff);
    Robot.hg.claw.set(DoubleSolenoid.Value.kOff);
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

