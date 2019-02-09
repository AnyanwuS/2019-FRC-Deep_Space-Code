/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.Drive;
import frc.robot.subsystems.*;

import frc.robot.commands.AutoLimeDrive;

/*
  The VM is configured to automatically run this class, and to call the
  functions corresponding to each mode, as described in the TimedRobot
  documentation. If you change the name of this class or the package after
  creating this project, you must also update the build.gradle file in the
  project.
*/
public class Robot extends TimedRobot {

  public static Limelight lm = new Limelight();
  public static DriveTrain dt = new DriveTrain();
  public static OxygenPusher op = new OxygenPusher();
  public static PDP pdp = new PDP();
  public static Roller rl = new Roller();

  public static RobotMap rm = new RobotMap();
  public static OI oi = new OI();

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  //INIT METHODS
  @Override
  public void robotInit(){
    oi = new OI();
    //TODO: Add drive modes (autonomous) to SmartDashboard here and in autonomousInit()
    m_chooser.setDefaultOption("Teleop Drive", new Drive());
    m_chooser.addOption("Auto Drive", new AutoLimeDrive());
    SmartDashboard.putData("Teleop", m_chooser);
  }

  @Override
  public void disabledInit(){
    /*
      Called once each time robot enters Disabled mode.
      Include code to reset or clear subsystems here.
    */
  }

  @Override
  public void teleopInit(){
    //Cancels autonomous mode upon initializing operator control
    if (m_autonomousCommand != null){
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void autonomousInit(){
    m_autonomousCommand = m_chooser.getSelected();
    /* Initialize autonomous drive code here and add it to Java SmartDashboard
    in robotInit() above. If you prefer the LabVIEW Dashboard, remove all
    of the chooser code and uncomment the getString code to get the auto name
    from the text box below the Gyro */

    /* Template for initializing auto drive command
    String autoSelected = SmartDashboard.getString("Auto Selector","Default");
    switch(autoSelected){
      case "My Auto":
        autonomousCommand = new MyAutoCommand();
        break;
      case "Default Auto":
        autonomousCommand = new ExampleCommand();
        break;
      }
    */

    //Add auto cmd to scheduler
    if (m_autonomousCommand != null){
      m_autonomousCommand.start();
    }
  }

  //PERIODIC FUNCTIONS
  @Override
  public void robotPeriodic(){
    /*
    Called every robot packet, regardless of mode. Include diagnostic/debug code
    here, but executes after mode-specific periodic functions and comes before
    LiveWindow and SmartDashboard integrated updating.
    */
  }

  @Override
  public void disabledPeriodic(){
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopPeriodic(){
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic(){
  }
}
