package org.usfirst.frc.team5340.robot.subsystems;

import org.usfirst.frc.team5340.robot.OI;
import org.usfirst.frc.team5340.robot.Robot;
import org.usfirst.frc.team5340.robot.RobotMap;
import org.usfirst.frc.team5340.robot.commands.DriveWStick;

import java.lang.Math;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    RobotDrive driveTrain;
    
    Talon leftMotor;
    Talon rightMotor;
    OI joysticks;
    
    double driveSpeed = 1;
    double turnSpeed = 1;
    
    public DriveTrain(){
        leftMotor = new Talon(RobotMap.LEFT_MOTOR);
        rightMotor = new Talon(RobotMap.RIGHT_MOTOR);
        driveTrain = new RobotDrive(rightMotor, leftMotor);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWStick());
    }
    
    public void teleDrive() {
        
        double forward = (-Robot.oi.driveStick1.getZ() + 1) / 2;
        double turn = (-Robot.oi.driveStick1.getZ() + 1) / 2;
        
        if(Robot.oi.driveStick1.getY() < 0) {
        	forward *= -Math.sqrt(Math.sqrt(Math.abs(Robot.oi.driveStick1.getY())));
        }
        else {
        	forward *= Math.sqrt(Math.sqrt((Robot.oi.driveStick1.getY())));
        }
        if(Robot.oi.driveStick1.getX() < 0) {
        	turn *= -Math.sqrt(Math.sqrt(Math.abs(Robot.oi.driveStick1.getX())));
        }
        else {
        	turn *= Math.sqrt(Math.sqrt(Robot.oi.driveStick1.getX()));
        }
        
//        forward *= Math.pow(Robot.oi.driveStick1.getY(), -1);
//        turn *= Math.pow(Robot.oi.driveStick1.getX(), -1);
        
        driveTrain.arcadeDrive(forward * driveSpeed, -(turn * turnSpeed));
        //driveTrain.tankDrive(Robot.oi.driveStick1.getY(), Robot.oi.driveStick2.getY());
        
//        As of right now (11/29/16) there is a negative value assigned to driveStick2's X value, the robot is strafing backwards this is the current fix.
//        Above problem has been fixed as of (12/some date/16)
        
    }
    
    public void autoTank() {
        driveTrain.tankDrive(-0.2, -0.2, true);
    }
}