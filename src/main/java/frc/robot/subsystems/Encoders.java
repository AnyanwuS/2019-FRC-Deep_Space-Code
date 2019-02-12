/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Encoder;

public class Encoders extends Subsystem {
  private static int encoderPortA = 11, encoderPortB = 12;
  private  Encoder m_encoder = new Encoder(encoderPortA, encoderPortB);

  public Encoders(){
    m_encoder.setDistancePerPulse((Math.PI * 4) / 360.0);
  }
  
  @Override
  public void initDefaultCommand(){

  }
}
