/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

//Pneumatics subsystem
public class OxygenPusher extends Subsystem {
  public boolean pushState = false;
  //Solenoids for the shifter; Only reconfigure if PCM CAN ID changes are necessary
  public DoubleSolenoid leftShifter = new DoubleSolenoid(0,1);
  public DoubleSolenoid rightShifter = new DoubleSolenoid(3,4);

  public void shiftPiston(Boolean shift){
    if(shift){
      //Activates piston
      leftShifter.set(DoubleSolenoid.Value.kForward);
      rightShifter.set(DoubleSolenoid.Value.kForward);
    }else{
      //Deactivates piston
      leftShifter.set(DoubleSolenoid.Value.kReverse);
      rightShifter.set(DoubleSolenoid.Value.kReverse);
    }
  }

  @Override
  public void initDefaultCommand(){
  }
}