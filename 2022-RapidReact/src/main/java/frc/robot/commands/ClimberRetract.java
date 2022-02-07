// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ClimberRetract extends CommandBase {
  /**
   * Creates a new ClimberRetract.
   *
   * @param subsystem The subsystem used by this command.
   */
  
  private Climber climber;
  private double speed;
  private Timer timerClimerRetract = new Timer();

  public ClimberRetract(Climber climber, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climber = climber;
    this.speed = speed;
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timerClimerRetract.reset();
    timerClimerRetract.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climber.retractClimber(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.retractClimber(0);

    timerClimerRetract.reset();
    timerClimerRetract.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timerClimerRetract.get() > 6.0;
  }
}
