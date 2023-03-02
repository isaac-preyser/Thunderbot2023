package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;

public class AutoDrive extends CommandBase{
    private final DriveSubsystem m_driveSubsystem;
    private Timer m_timer;
    private double time;
    
    public AutoDrive(DriveSubsystem driveSubsystem, double time){
        this.m_driveSubsystem = driveSubsystem;
        this.m_timer = new Timer();
        this.time = time;
    }

    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    public void execute(){
        m_driveSubsystem.drive(0.4, 0.0);
        System.out.println("Driving");
    }

    public boolean isFinished(){
        return m_timer.get() >= time;
    }
    public void end(){
        m_driveSubsystem.drive(0, 0);
    }
}
