package org.usfirst.frc.team2783.robot.subsystems;

import org.usfirst.frc.team2783.robot.RobotMap;
import org.usfirst.frc.team2783.robot.commands.DriveClamper;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Clamper extends Subsystem {
    
    TalonSRX clamperTalon = new TalonSRX(RobotMap.clamperMotorId);
    Encoder clamperEncoder = new Encoder(
    	RobotMap.clamperEncoderChannelA, 
    	RobotMap.clamperEncoderChannelB
    );

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveClamper());
    }
    
    public void setClamperSpeed(double speed) {
    	clamperTalon.set(speed);
    }
    
    public double getEncoderCount() {
    	return clamperEncoder.get();
    }
    
    public double getEncoderRate() {
    	return clamperEncoder.getRate();
    }
}
