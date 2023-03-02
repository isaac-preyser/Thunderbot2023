// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.auto;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

import frc.robot.commands.*;
import frc.robot.subsystems.*;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
*
*/
public class AutonomousCommand extends SequentialCommandGroup {
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    
    private DriveSubsystem m_DriveSubsystem;

    public AutonomousCommand(DriveSubsystem driveSubsystem) {
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);    
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        this.m_DriveSubsystem = driveSubsystem;

        addCommands(
            new SequentialCommandGroup(
                new AutoDrive(m_DriveSubsystem, 2000)
            )
        );

    }
    
    // Called when the command is initially scheduled.
    //@Override
    //public void initialize() {
    //}
    
    // Called every time the scheduler runs while the command is scheduled.
    //@Override
    //public void execute() {
    //}
    
    // Called once the command ends or is interrupted.
    //@Override
    //public void end(boolean interrupted) {
    //}
    
    // Returns true when the command should end.
    //@Override
    //public boolean isFinished() {
    //    return false;
    //}
    
    //@Override
    //public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    //    return false;
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    //}
}
