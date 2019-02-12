/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.can.*;
//Pneumatics subsystem for conveyor
public class Conveyors extends Subsystem {
  //TODO: Integrate into Piston.java

  public WPI_TalonSRX conveyorMotor = new WPI_TalonSRX(RobotMap.conveyor);
  //Solenoids for the shifter; Only reconfigure if PCM CAN ID changes are necessary
  public DoubleSolenoid LeftConveyor = new DoubleSolenoid(4,5);
  public DoubleSolenoid RightConveyor = new DoubleSolenoid(6,7);


  public void toggleConveyor(Boolean enabled){
    /*
      //Activates piston
      LeftConveyor.set(DoubleSolenoid.Value.kForward);
      RightConveyor.set(DoubleSolenoid.Value.kForward);
      //Deactivates piston
      LeftConveyor.set(DoubleSolenoid.Value.kReverse);
      RightConveyor.set(DoubleSolenoid.Value.kReverse);
    */
  }

  public void setMotor(double power){
    conveyorMotor.set(-power);
  }

  public void stop(){
    conveyorMotor.set(0.0);
  }

  @Override
  public void initDefaultCommand(){
  }
}