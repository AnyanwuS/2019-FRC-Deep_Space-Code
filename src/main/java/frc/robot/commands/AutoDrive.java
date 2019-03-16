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
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.followers.EncoderFollower;


public class AutoDrive extends Command {

  EncoderFollower left, right;
  TankModifier modifier = Robot.dt.createTrajectory();
  
  double gyro_heading, desired_heading, angleDiff, turn;

  public AutoDrive(){
    requires(Robot.dt);

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

    gyro_heading = Robot.nx.getAngle();
    desired_heading = Pathfinder.r2d(left.getHeading());

    angleDiff = Pathfinder.boundHalfDegrees(
      desired_heading - gyro_heading) % 360.0;
    if (Math.abs(angleDiff) > 180.0){
      angleDiff = (angleDiff > 0) ? angleDiff - 360 : angleDiff + 360;
    }
    turn = 0.8 * (-1.0/80.0) * angleDiff;

    Robot.dt.frontLeft.set(l+turn);
    Robot.dt.frontRight.set(r-turn);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }
  
  @Override
  protected void interrupted() {
  }
}
