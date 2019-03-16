/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groups;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

//Example CommandGroup
public class CargoHatch extends CommandGroup {
  /*
  CommandGroups are able to run multiple commands either sequentially on in parallel
  addSequential(new Command()) statements will run the parametrized commands in the order they are called
  addParallel(new Command()) statements will run commands at the same time as other commands called with addParallel()
  */
  public CargoHatch(){
    addSequential(new HG_InitExtend(), 0.1);
    addSequential(new WaitCommand(0.6));
    addSequential(new HG_Claw(), 0.1);
    addSequential(new WaitCommand(0.25));
    addSequential(new HG_InitExtend(), 0.1);
  }
}
