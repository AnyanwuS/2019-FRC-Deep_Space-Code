package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command autonomously drives the robot forward at a fixed level of power for a given amount of time
 */
public class TimedDrive extends Command {

    private long time = 0;
    private double duration = 0, pwr = 0;

    public TimedDrive(double length, double power) {
        requires(Robot.dt);
        this.setTimeout(3);
        this.pwr = power;
        this.duration = length * 1000;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        time = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.dt.ArcadeDrive(pwr, 0);
        Timer.delay(0.005);
    }


    protected boolean isFinished() {
        if (this.isTimedOut()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.dt.ArcadeDrive(0, 0);
    }
}