// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
    private final Shooter shooter;

    private Timer timer = new Timer();

    public Shoot(Shooter shooter) {
        addRequirements(shooter);
        this.shooter = shooter;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        shooter.turnOnShooter();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.turnOffShooter();
    }

    @Override
    public boolean isFinished() {
        return timer.get() > 1.5;
    }
}
