// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  private final DriveSubsystem driveSubsystem;
  private final Supplier<Double> speedFunction, turnFunction;

  public ArcadeDrive(DriveSubsystem driveSubsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.driveSubsystem = driveSubsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //get latest values of joysticks, speed and turn. 
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    double leftSpeed = realTimeSpeed + realTimeTurn;
    double rightSpeed = realTimeSpeed - realTimeTurn;
    System.out.println("Left Speed: " + leftSpeed + " Right Speed: " + rightSpeed + "");
    driveSubsystem.setMotors(leftSpeed, rightSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
