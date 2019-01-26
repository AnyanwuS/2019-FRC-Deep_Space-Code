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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrain extends Subsystem {
  //Declare TalonSRX motors
  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.leftMaster);
  public WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.rightMaster);
  public WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotMap.leftSlave);
  public WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotMap.rightSlave);
  public WPI_TalonSRX midLeft = new WPI_TalonSRX(RobotMap.leftDonkey);
  public WPI_TalonSRX midRight = new WPI_TalonSRX(RobotMap.rightDonkey);

  public DifferentialDrive dt = new DifferentialDrive(frontLeft, frontRight);

  public DriveTrain(){
    //Sets rear motors to follow rotation of the primary motors
    dt.setSafetyEnabled(false);
    rearLeft.follow(frontLeft);
    rearRight.follow(frontRight);
  }

  public void ArcadeDrive (double x, double rotation){
    dt.arcadeDrive(-x, rotation);
  }

  @Override
  public void initDefaultCommand(){
    setDefaultCommand(new Drive());
  }
}
