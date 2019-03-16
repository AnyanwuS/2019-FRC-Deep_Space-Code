package frc.robot.subsystems;
 
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.AHRS;
 
 /*
 Gyro subsystem using the NavX
 */
public class NavX extends Subsystem {
 
  AHRS robotGyro = new AHRS(SPI.Port.kMXP);//MXP port is that long rectangular port in the middle of the RIO
 
  //Do this before every match, so call it in Autonomous
  public void resetGyro() {
    robotGyro.reset();
  }

  //Return 
  public double getAngle() {
    double angle = robotGyro.getAngle();
    return angle;
  }
 
  @Override
  public void initDefaultCommand() {
  }
}