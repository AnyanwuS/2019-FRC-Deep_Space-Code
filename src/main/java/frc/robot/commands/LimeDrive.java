/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.OI;
//import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj.Timer;
/**
 * An example command.  You can replace me with your own command.
 */
public class LimeDrive extends Command {
  public LimeDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.dt);
    requires(Robot.lm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double headingError = Robot.lm.getHorizontalOffset();
    double steeringAdjust = 0.0f;
    double Kp = 0.07;
    double minPower = 0.0;


    //System.out.println("LED should be force blinking");
    if(Robot.lm.getHorizontalOffset() > 1){
      steeringAdjust = Kp * headingError - minPower;
      //System.out.println(steeringAdjust + "\n" +  headingError + "right");
    }
    else if(headingError < 1){
      steeringAdjust = Kp * headingError + minPower;
      //System.out.println(steeringAdjust + "\n" + headingError + "left" );
      
    }

    Robot.dt.ArcadeDrive(Robot.oi.driver.getRawAxis(1), steeringAdjust);
    Timer.delay(.005);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;//was false 
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