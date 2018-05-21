package org.usfirst.frc.team5340.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5340.robot.commands.Avoid;
import org.usfirst.frc.team5340.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;

/**
 *
 */
public class Avoider extends Subsystem {
	
	static Ultrasonic ultra = new Ultrasonic(RobotMap.FRONT_ULTRA, RobotMap.FRONT_ULTRA);
	
	public static double distance_allow = 400;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static double getDistance() {
		return ultra.getRangeMM();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Avoid());
    }
}

