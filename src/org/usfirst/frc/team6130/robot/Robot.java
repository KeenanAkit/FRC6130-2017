
package org.usfirst.frc.team6130.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
	
    Talon leftDrive; 
    Talon leftDrive2;
    Talon rightDrive;
    Talon rightDrive2;
    Spark intake;
    Spark shooter;
    Compressor comp;
    
    Joystick driver;
    Joystick operator;
    boolean shoot;
    boolean intakeOn;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        
        leftDrive = new Talon(0);
        leftDrive2 = new Talon(1);
        rightDrive = new Talon(2);
        rightDrive2 = new Talon(3);
        intake = new Spark(4);
        shooter = new Spark(5);
        comp = new Compressor(0);
        
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void intakeSet(){
    	intake.set(1);
    }
    public void teleopPeriodic() {
        leftDrive.set(-driver.getRawAxis(1));
        leftDrive2.set(-driver.getRawAxis(1));
        rightDrive.set(driver.getRawAxis(5));
        rightDrive2.set(driver.getRawAxis(5));
        
        shoot = operator.getRawButton(1);
        intakeOn = operator.getRawButton(2);
        
        if(shoot == true){
        	shooter.set(1);
        }else{
        	shooter.set(0);
        }
        if(intakeOn == true){
        	intake.set(1);
        }else{
        	intake.set(0);
        }
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
