package org.usfirst.frc.team5340.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5340.robot.Robot;
/**
 *
 */
public class DriveWStick extends Command {

    public DriveWStick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveSub.fairBotTank();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
