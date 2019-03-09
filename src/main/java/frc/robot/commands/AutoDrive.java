/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import jaci.pathfinder.modifiers.TankModifier;
import jaci.pathfinder.followers.EncoderFollower;


public class AutoDrive extends Command {

  EncoderFollower left, right;

  public AutoDrive(){
    requires(Robot.dt);
    TankModifier modifier = Robot.dt.createTrajectory();

    left = new EncoderFollower(modifier.getLeftTrajectory());
    right = new EncoderFollower(modifier.getRightTrajectory());

    left.configureEncoder(
      Robot.dt.frontLeft.getSelectedSensorPosition(), 4096, 0.1524);
    right.configureEncoder(
      Robot.dt.frontRight.getSelectedSensorPosition(), 4096, 0.1524);

    left.configurePIDVA(1.0, 0.0, 0.0, 1 / Robot.dt.config.max_velocity, 0.0);
    right.configurePIDVA(1.0, 0.0, 0.0, 1 / Robot.dt.config.max_velocity, 0.0);

  }

  @Override
  protected void initialize(){
  }

  @Override
  protected void execute(){
    double l = left.calculate(
      Robot.dt.frontLeft.getSelectedSensorPosition());
    double r = right.calculate(
      Robot.dt.frontLeft.getSelectedSensorPosition());

    Robot.dt.frontLeft.set(l);
    Robot.dt.frontRight.set(r);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
