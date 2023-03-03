// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.auto.AutonomousCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final GyroSubsystem m_gyroSubsystem = new GyroSubsystem();
    public final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
    public final ArmSubsystem m_armSubsystem = new ArmSubsystem();

// Joysticks
private final XboxController driverController = new XboxController(Constants.OIConstants.kDriverControllerPort);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Raise Arm", new RaiseArm( m_armSubsystem ));
    SmartDashboard.putData("Lower Arm", new LowerArm( m_armSubsystem ));
    SmartDashboard.putData("Open Hand", new OpenHand( m_armSubsystem ));
    SmartDashboard.putData("Close Hand", new CloseHand( m_armSubsystem ));
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand(m_driveSubsystem, 4));
    SmartDashboard.putData("Raise Second Joint", new SecondJointRaise(m_armSubsystem));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    //set up drive subsystem default command, to arcade drive mode. 
     

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand(m_driveSubsystem, 4));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
    //SmartDashboard.putData("Last Command", null);
  }

  void configureDefaultCommands() {
    m_driveSubsystem.setDefaultCommand(new ArcadeDrive(m_driveSubsystem, //
      () -> driverController.getLeftY(),
      () -> driverController.getRightX() //
        )
    );
    
    m_armSubsystem.setDefaultCommand(new SetArmCommand(m_armSubsystem, //
    () -> driverController.getLeftTriggerAxis(),
    () -> driverController.getRightTriggerAxis() //
      )
    );
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton buttonCloseHand = new JoystickButton(driverController, XboxController.Button.kA.value);        
buttonCloseHand.onFalse(new CloseHand( m_armSubsystem ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("buttonCloseHand",new CloseHand( m_armSubsystem )); 


final JoystickButton buttonOpenHand = new JoystickButton(driverController, XboxController.Button.kA.value);        
buttonOpenHand.onTrue(new OpenHand( m_armSubsystem ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("buttonOpenHand",new OpenHand( m_armSubsystem ));
                       
//set raising and lowering of arm to dpad. 
final POVButton buttonRaiseFirstStage = new POVButton(driverController, 0);
buttonRaiseFirstStage.onTrue(new RaiseArm(m_armSubsystem).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("buttonRaiseFirstStage",new RaiseArm( m_armSubsystem ));
buttonRaiseFirstStage.onFalse(new SetArmCommand(m_armSubsystem, //
() -> driverController.getLeftTriggerAxis(),
() -> driverController.getRightTriggerAxis() //
  )
);
final POVButton buttonLowerFirstStage = new POVButton(driverController, 180);
buttonLowerFirstStage.onTrue(new LowerArm(m_armSubsystem).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("buttonLowerFirstStage",new LowerArm( m_armSubsystem ));
buttonLowerFirstStage.onFalse(new SetArmCommand(m_armSubsystem, //
() -> driverController.getLeftTriggerAxis(),
() -> driverController.getRightTriggerAxis() //
  )
);
//when the both triggers are at 0, do not move the arm. use the right trigger as a positive movement up, and the left as movement down. 
//therefore RT - LT = direction of movement. If negative, move the arm down. 
//don't use below code.
//final Trigger raiseLowerArm = new Trigger(driverController.getRightTriggerAxis() - driverController.getLeftTriggerAxis() != 0){ 




  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public XboxController getDriverController() {
      return driverController;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

