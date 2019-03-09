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

//Conveyor subsystem including the pivot system and motor belt
public class Conveyor extends Subsystem {

  public WPI_TalonSRX conveyor = new WPI_TalonSRX(RobotMap.conveyor);
  public DoubleSolenoid pusher = new DoubleSolenoid(0,0,1);

  public void setPower(double power){
    conveyor.set(-power);
  }

  public void raisePivot(){
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
    conveyor.set(0.0);
  }
  
  @Override
  protected void initDefaultCommand(){
    setDefaultCommand(null);
  }
}