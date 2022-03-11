// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ActivateConveyor;
import frc.robot.commands.GrabBalls;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.StorageSystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeAndConveyor extends ParallelCommandGroup {

  /** Creates a new Inwtaker. */
  public IntakeAndConveyor(Intake intake, StorageSystem storageSystem){
    addCommands(
      new GrabBalls(intake, Constants.Intake.MAX_SPEED),
      new ActivateConveyor(storageSystem, Constants.Storage.SPEED)
    );
  }
  public IntakeAndConveyor(Intake intake, StorageSystem storageSystem, Boolean isInverted){
    addCommands(
      new GrabBalls(intake, -Constants.Intake.MAX_SPEED),
      new ActivateConveyor(storageSystem, -Constants.Storage.SPEED)
    );
  }
}

