/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groups;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLimeDrive extends CommandGroup {
  /*
  Additionally drives towards the target in addition to adjusting towards the target
  */
  public AutoLimeDrive(){
    addSequential(new LimeDrive());
    addSequential(new TimedDrive(0.5, 0, 3));
  }
}
