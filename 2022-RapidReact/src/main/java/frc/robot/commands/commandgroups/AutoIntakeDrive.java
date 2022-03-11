// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.auto.AutoIntake;
import frc.robot.commands.auto.DriveStraight;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoIntakeDrive extends ParallelCommandGroup {

  /** Creates a new Inwtaker. */
  public AutoIntakeDrive(Intake intake, frc.robot.subsystems.DriveTrain driveTrain, double speed, double time){
    addCommands(
      new AutoIntake(intake, time),
      new DriveStraight(driveTrain, speed, time) 
    );
  }
}

