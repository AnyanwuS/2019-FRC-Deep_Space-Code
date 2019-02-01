/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;;

/**
 * Add your docs here.
 */
public class Roller extends Subsystem {
  public PowerDistributionPanel pdp = new PowerDistributionPanel();

  public WPI_TalonSRX RoadRoller = new WPI_TalonSRX(RobotMap.roadRoller);
  
  public void intake(){
      RoadRoller.set(0.8);
  }
  public void exhaust(){
  RoadRoller.set(-0.8);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
