// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
*
*/
public class DriveSubsystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Spark leftFront;
    private Spark leftBack;
    private MotorControllerGroup leftMotors;
    private Spark rightFront;
    private Spark rightBack;
    private MotorControllerGroup rightMotors;
    private DifferentialDrive differentialDrive1;
    
    private double encoderTicks;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftFront = new Spark(Constants.DriveConstants.kLeftMotor1Port);
        addChild("Left Front",leftFront);
        leftFront.setInverted(true);
        
        leftBack = new Spark(Constants.DriveConstants.kLeftMotor2Port);
        addChild("Left Back",leftBack);
        leftBack.setInverted(true);
        
        leftMotors = new MotorControllerGroup(leftFront, leftBack  );
        addChild("LeftMotors",leftMotors);
        
        
        rightFront = new Spark(Constants.DriveConstants.kRightMotor1Port);
        addChild("Right Front",rightFront);
        rightFront.setInverted(false);
        
        rightBack = new Spark(Constants.DriveConstants.kRightMotor2Port);
        addChild("Right Back",rightBack);
        rightBack.setInverted(false);
        
        rightMotors = new MotorControllerGroup(rightFront, rightBack  );
        addChild("RightMotors",rightMotors);
        
        
        differentialDrive1 = new DifferentialDrive(leftMotors, rightMotors);
        addChild("Differential Drive 1",differentialDrive1);
        differentialDrive1.setSafetyEnabled(true);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);
        
        
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        //instantiate and prepare encoders 

        //zero encoders
        encoderTicks = 0; 
        //set up smart dashboard 
        SmartDashboard.putNumber("encoder data", encoderTicks);

    }
    
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        
    }
    
    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
        
    }

    public void drive(double xSpeed, double rotation) {
        differentialDrive1.arcadeDrive(xSpeed, rotation);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
}

