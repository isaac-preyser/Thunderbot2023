// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class setEncoderTarget extends CommandBase {
  /** Creates a new setEncoderTarget. */
  private final ArmSubsystem m_ArmSubsystem;


  public setEncoderTarget(ArmSubsystem m_ArmSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_ArmSubsystem = m_ArmSubsystem;
    addRequirements(m_ArmSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double target = SmartDashboard.getNumber("Target Value", 0);
    m_ArmSubsystem.degreestoTicks(target);
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
