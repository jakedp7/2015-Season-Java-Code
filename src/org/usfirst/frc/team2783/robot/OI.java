package org.usfirst.frc.team2783.robot;

import org.usfirst.frc.team2783.robot.commands.CenterCamera;
import org.usfirst.frc.team2783.robot.commands.CloseClamper;
import org.usfirst.frc.team2783.robot.commands.LowerLifter;
import org.usfirst.frc.team2783.robot.commands.RaiseLifter;
import org.usfirst.frc.team2783.robot.triggers.Dpad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoystickId);
	public static Joystick manipulatorJoystick = new Joystick(RobotMap.manipulatorJoystickId);
	
	Trigger raiseLifterTrigger = new Dpad(manipulatorJoystick, 0, 0);
	Trigger lowerLifterTrigger = new Dpad(manipulatorJoystick, 0, 180);
	
	Button centerCameraButton = new JoystickButton(manipulatorJoystick, 9);
	Button autoCloseButton = new JoystickButton(manipulatorJoystick, 5);
	
	public OI() {
		raiseLifterTrigger.whenActive(new RaiseLifter());
		lowerLifterTrigger.whenActive(new LowerLifter());
		
		centerCameraButton.whenPressed(new CenterCamera());
		autoCloseButton.whenPressed(new CloseClamper());
	}
}

