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

import frc.robot.commands.*;
import frc.robot.commands.groups.*;
import frc.robot.subsystems.*;

/*
  The VM is configured to automatically run this class, and to call the
  functions corresponding to each mode, as described in the TimedRobot
  documentation. If you change the name of this class or the package after
  creating this project, you must also update the build.gradle file in the
  project.
*/
public class Robot extends TimedRobot {
  //Subsystem instancing
  public static Limelight lm = new Limelight();
  public static Drivetrain dt = new Drivetrain();
  public static HatchGrabber hg = new HatchGrabber();
  public static Feeder fd = new Feeder();
  public static Conveyor cv = new Conveyor();
  public static NavX nx = new NavX();
  public static RobotMap rm = new RobotMap();
  public static OI oi;

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
    nx.resetGyro();
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
    lm.camMode(1);
    if (m_autonomousCommand != null){
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void autonomousInit(){
    nx.resetGyro();
    //Scheduler.getInstance().run();
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
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic(){
  }
}
