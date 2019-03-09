/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Feeder extends Subsystem {
  
  public WPI_TalonSRX feeder = new WPI_TalonSRX(RobotMap.feeder);
  public DoubleSolenoid pusher = new DoubleSolenoid(0,2,3);

  public Feeder(){
  }

  public void setPower(double power){
    feeder.set(power);
  }

  public void raiseFeeder(){
    switch (pusher.get()){
      case kOff:
        pusher.set(DoubleSolenoid.Value.kForward);
        break;
      case kForward:
        pusher.set(DoubleSolenoid.Value.kReverse);
        break;
      case kReverse:
        pusher.set(DoubleSolenoid.Value.kForward);
        break;
    }
  }
  
  public void stop(){
    feeder.set(0.0);
  }

  @Override
  public void initDefaultCommand(){
    setDefaultCommand(null);
  }
}
