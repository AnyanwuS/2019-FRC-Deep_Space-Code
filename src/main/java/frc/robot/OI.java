/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import frc.robot.commands.*;
import frc.robot.commands.groups.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
This class is the glue that binds the controls on the physical operator
interface (controller) to the commands and command groups that allow control of the robot.
*/
public class OI {
	//Driver: Drivetrain control, Operator: Other functions
	public static Joystick driver = new Joystick(0);
	public static Joystick operator = new Joystick(1);
	public static Joystick autonomousSelect = new Joystick(2);
	
	/* Logitech controller binds (replaces Start & Select)
	static Button Back = new JoystickButton(driver, 7);
	static Button Start = new JoystickButton(driver, 8);
	*/

	//Attach raw button inputs to their corresponding names
	Button A = new JoystickButton(driver, 1);
	Button B = new JoystickButton(driver, 2);
	Button X = new JoystickButton(driver, 3);
	Button Y = new JoystickButton(driver, 4);
	Button LB = new JoystickButton(driver, 5);
	Button RB = new JoystickButton(driver, 6);
	Button Start = new JoystickButton(driver, 7);
	Button Select = new JoystickButton(driver, 8);

	Button opA = new JoystickButton(operator, 1);
	Button opB = new JoystickButton(operator, 2);
	Button opX = new JoystickButton(operator, 3);
	Button opY = new JoystickButton(operator, 4);
	Button opLB = new JoystickButton(operator, 5);
	Button opRB = new JoystickButton(operator, 6);
	Button opStart = new JoystickButton(operator, 7);
	Button opSelect = new JoystickButton(operator, 8);
	
	public static int leftX = 0;
	public static int leftY = 1;
	public static int rightX = 4;
	public static int rightY = 5;
	public static int leftTrigger = 2;
  	public static int rightTrigger = 3;
	  
  public OI(){
	  //Bind commands to buttons here
	  /*TODO: Toggle command to switch direction of arcade drive for teleop
	  Select.whenPressed(new switchMode());*/
	  A.toggleWhenPressed(new Belt());
	  Y.whenPressed(new Pivot());
	  RB.whenPressed(new Extender());
	  LB.whenPressed(new Claw());
	  /*
	  TODO: Rewrite motor constructors to take power parameters;
	  Write a Config.java with constants to easily adjust motor power &
	  other constants
	  */
  }	
}
