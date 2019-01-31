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
  //Maps to CAN ID of motors
  public static int leftMaster = 11;
  public static int leftSlave = 12;
  public static int rightMaster = 13;
  public static int rightSlave = 14;
  public static int leftDonkey = 16;
  public static int rightDonkey = 15;

  /*
    If you are using multiple modules, make sure to define
    both the port number and the module as separate variables
  */
}
