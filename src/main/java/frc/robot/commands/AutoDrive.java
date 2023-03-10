package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;

public class AutoDrive extends CommandBase{
    private final DriveSubsystem m_driveSubsystem;
    private final Timer m_timer;
    private final double time;
    
    public AutoDrive(DriveSubsystem driveSubsystem, double time){
        this.m_driveSubsystem = driveSubsystem;
        this.m_timer = new Timer();
        this.time = time;
    }

    public void initialize() {
        m_timer.reset();
        m_timer.start();
        System.out.println("Starting");
        
    }

    public void execute(){
        m_driveSubsystem.drive(-0.7, 0.0);
        System.out.println("Driving. Time: " + m_timer.get() + " seconds");
    }

    public boolean isFinished(){
        return m_timer.hasElapsed(time); //when time expires, stop driving
    }
    public void end(){
        System.out.println("Stopped");
        m_driveSubsystem.drive(0, 0); //stop driving
        
    }
}
