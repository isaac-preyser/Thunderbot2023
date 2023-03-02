// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmCommand extends CommandBase {
  /** Creates a new SetArmCommand. */
  private final ArmSubsystem m_armSubystem; 
  private final Supplier<Double> leftTrigger, rightTrigger;
  

  public SetArmCommand(ArmSubsystem armSubsystem, Supplier<Double> leftTrigger, Supplier<Double> rightTrigger) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_armSubystem = armSubsystem;
    this.leftTrigger = leftTrigger;
    this.rightTrigger = rightTrigger;
    addRequirements(armSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double neg = leftTrigger.get();
    double pos = rightTrigger.get();

    double posValue = (pos - neg);
    m_armSubystem.setConveyor(posValue);
   // System.out.println("Arm position: " + posValue);
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
