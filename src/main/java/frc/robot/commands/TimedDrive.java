package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command autonomously drives the robot forward at a fixed level of power for a given amount of time
 */
public class TimedDrive extends Command {

    private double x, y;

    public TimedDrive(double y, double x, double duration) {
        requires(Robot.dt);
        this.x = x;
        this.y = y;
        this.setTimeout(duration);
    }

    protected void initialize(){
    }

    protected void execute(){
        Robot.dt.ArcadeDrive(-y, x);
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