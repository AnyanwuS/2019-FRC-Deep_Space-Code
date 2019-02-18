/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.*;

public class PDP extends Subsystem {
  /* Subsystem that relays mainly diagnostic information
  regarding the PDP and its connected devices
  */
  PowerDistributionPanel pdp = new PowerDistributionPanel();

  public Map<String,Double> getInfo(){
    //Measures power draw for all connected ports
    Map<String, Double> info = new HashMap<String, Double>();
    info.put("PDP Current Draw", pdp.getTotalCurrent());
    info.put("Input Voltage", pdp.getVoltage());
    return info;
  }

  @Override
  public void initDefaultCommand(){
    setDefaultCommand(null);
  }
}
