/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import frc.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class Drivetrain extends Subsystem {
  public double[] velocity = new double[2];
  //Motor controllers for drivetrain
  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.leftMaster);
  public WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.rightMaster);
  public WPI_VictorSPX rearLeft = new WPI_VictorSPX(RobotMap.leftSlave);
  public WPI_VictorSPX rearRight = new WPI_VictorSPX(RobotMap.rightSlave);
  public WPI_VictorSPX middleLeft = new WPI_VictorSPX(RobotMap.leftDonkey);
  public WPI_VictorSPX middleRight = new WPI_VictorSPX(RobotMap.rightDonkey);

  public DifferentialDrive dd = new DifferentialDrive(frontLeft, frontRight);
  //Fit, samples, dt, maxV, maxA, maxJ 
  public Trajectory.Config config = new Trajectory.Config(
      Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 
      0.05, 3.48, 10.5, 60.0);

  Waypoint[] points = new Waypoint[] {
    new Waypoint(-4, -1, Pathfinder.d2r(-45)),
    new Waypoint(-2, -2, 0),
    new Waypoint(0, 16, 0)
  };

  public TankModifier createTrajectory(){
    // Wheelbase Width = 0.5m
    Trajectory trajectory = Pathfinder.generate(points, config);
    TankModifier modifier = new TankModifier(trajectory).modify(0.524);
    return modifier;
  }

  public Drivetrain(){
    dd.setSafetyEnabled(false);
    //Create followers for the master controllers
    rearLeft.follow(frontLeft);
    rearRight.follow(frontRight);
    middleLeft.follow(frontLeft);
    middleRight.follow(frontRight);
    //Initialize and bind coders to master talon controllers
    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
  }

  public void ArcadeDrive (double x, double rotation){
    //Motion in the -x direction is actually forward
    dd.arcadeDrive(-x, rotation);
  }
  
  public double[] encoderVelocity(){
    //Returns velocity of both sides of the drivetrain
    double wheelCircumference = 0.1524*Math.PI;
    
    velocity[0] = -((frontLeft.getSelectedSensorVelocity()
    /4096.0)*wheelCircumference)*10.0;
    velocity[1] = ((frontRight.getSelectedSensorVelocity()
    /4096.0)*wheelCircumference)*10.0;

    return velocity;
  }

  @Override
  public void initDefaultCommand(){
    setDefaultCommand(new Drive());
  }
}
