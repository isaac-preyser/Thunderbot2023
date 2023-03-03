// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class AutoBalance extends CommandBase {
  /** Creates a new AutoBalance. */
  private DriveSubsystem m_Drive;
  private GyroSubsystem m_Gyro;
  private boolean finished = false;



  public AutoBalance(DriveSubsystem m_DriveSubsystem, GyroSubsystem m_GyroSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_DriveSubsystem);
    addRequirements(m_GyroSubsystem);

    this.m_Drive = m_DriveSubsystem;
    this.m_Gyro = m_GyroSubsystem;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double currentAngle = m_Gyro.angle;
    double acceptableAngleOffset = 5.0; //the amount, plus or minus, that the robot should tolerate as "docked".

    System.out.println("Current Angle: " + currentAngle);

    if (currentAngle < -acceptableAngleOffset){
      System.out.println("Moving Backwards");
      m_Drive.drive(-0.1, 0);
    }
    if (currentAngle > acceptableAngleOffset){
      System.out.println("Moving Forwards");
      m_Drive.drive(0.1, 0);
    }
    if (currentAngle < acceptableAngleOffset && currentAngle > -acceptableAngleOffset){
      m_Drive.drive(0,0);
      //finished = true;
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
