/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Robot;
import frc.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(Robot.rm.leftMaster);
  public WPI_TalonSRX frontRight = new WPI_TalonSRX(Robot.rm.rightMaster);
  public WPI_TalonSRX rearLeft = new WPI_TalonSRX(Robot.rm.leftSlave);
  public WPI_TalonSRX rearRight = new WPI_TalonSRX(Robot.rm.rightSlave);

  public DifferentialDrive dt = new DifferentialDrive(frontLeft, frontRight);

  public DriveTrain(){
    dt.setSafetyEnabled(false);
    rearLeft.follow(frontLeft);
    rearRight.follow(frontRight);
  }


  public void ArcadeDrive (double x, double rotation) {

    dt.arcadeDrive(-x, rotation);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }
}
