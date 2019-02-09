package frc.robot.commands;

import frc.robot.Robot;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command autonomously drives the robot forward at a fixed level of power for a given amount of time
 */
public class TimedDrive extends Command {

    private double x = 0, y = 0;

    public TimedDrive(double x, double y, double duration) {
        requires(Robot.dt);
        this.x = x;
        this.y = y;
        this.setTimeout(duration);
    }

    // Called just before this Command runs the first time
    protected void initialize(){
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
        Robot.dt.ArcadeDrive(-x, y);
        Timer.delay(0.005);
    }


    protected boolean isFinished(){
        if (this.isTimedOut()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end(){
        Robot.dt.ArcadeDrive(0, 0);
    }
}