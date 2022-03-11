// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberCommand extends CommandBase {

  private Climber climber;
  private double speed;
  private double time;
  private Timer timer = new Timer();

  public ClimberCommand(Climber climber, double speed, double time) {
    this.climber = climber;
    this.speed = speed;
    addRequirements(climber);
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    if(timer.get() <= time/2){
      climber.upClimber(speed);
    } else if((timer.get() > time/2)){
      climber.downClimber(speed);
    }
  }

  @Override
  public void end(boolean interrupted) {
    climber.upClimber(0);
    climber.downClimber(0);
    timer.stop();
  }

  @Override
  public boolean isFinished() {
    return timer.get() > time;
  }
}

