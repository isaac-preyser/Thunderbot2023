// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.test;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GyroSubsystem;

public class SetGyro extends CommandBase {
  /** Creates a new SetGyro. */
  double target;
  GyroSubsystem m_gyro;
  char axis; 
  boolean isFinished = false;


  public SetGyro(GyroSubsystem g, double t, char c) {
    addRequirements(g);
    this.target = t;
    this. m_gyro = g;
    this.axis = c;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_gyro.setAngle(target, axis);
    System.out.println("Target angle of: " + target + " set on the " + axis + "axis");
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
