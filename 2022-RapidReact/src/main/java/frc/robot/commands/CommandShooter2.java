// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class CommandShooter2 extends CommandBase {

  private Timer timer = new Timer();
  private double time = 0;
  private Shooter shooter;


  public CommandShooter2(Shooter shooter) {
    addRequirements(shooter);
    this.shooter = shooter;
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    time = timer.get();
    shooter.turnOnShooter();
    
  }

  @Override
  public void end(boolean interrupted) {
    shooter.turnOffShooter();
  }

  @Override
  public boolean isFinished() {
    return time > 1.5;
  }
}
