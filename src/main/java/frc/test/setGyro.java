// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.test;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GyroSubsystem;

public class setGyro extends CommandBase {
  /** Creates a new setGyro. */
  GyroSubsystem gyro;
  double target;

  public setGyro(GyroSubsystem m_gyro, double target) {
    this.gyro = m_gyro;
    this.target = target; 
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_gyro);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Target = " + target + " On subsystem: " + gyro);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //gyro.setAngle();
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
