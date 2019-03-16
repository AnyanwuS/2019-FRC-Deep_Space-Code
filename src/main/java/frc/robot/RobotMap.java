/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/*
  The RobotMap is a mapping from the ports sensors and actuators are wired into
  to a variable name. This provides flexibility changing wiring, makes checking
  the wiring easier and significantly reduces the number of magic numbers floating around.
*/
public class RobotMap {
  //CIM motor CAN IDs
  public static int leftMaster = 11;
  public static int leftSlave = 12;
  public static int rightMaster = 13;
  public static int rightSlave = 14;
  public static int leftDonkey = 16;
  public static int rightDonkey = 15;
  //775 motor CAN IDs
  public static int conveyor = 17;
  public static int feeder = 18;
  /*
    If you are using multiple modules, make sure to define
    both the port number and the module as separate variables
  */
  public static final double beltPower = 1.0;
  public static final double feederPower = 1.0;
  //Limelight
  public static final double Kp = 0.007;
  public static final double mountAngle = 25.0;

  public static final double cameraHeight = 1.168; //Camera height in meters
  public static final double rcHeight = 0.925; //Rocket cargo height in meters
  public static final double hpHeight = 0.699; //Hatch panel height in meters
  public static final double scHeight = 0.710; //Cargo ship height in meters
}
