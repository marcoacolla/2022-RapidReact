// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.auto.AutoStorage;
import frc.robot.commands.auto.AutoIntake;
import frc.robot.commands.auto.AutoShoot;
import frc.robot.commands.auto.DriveStraight;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.StorageSystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoRoutine extends ParallelCommandGroup {
  /** Creates a new AutoRoutineShooter. */
  public AutoRoutine(StorageSystem storageSystem, Shooter shooter, frc.robot.subsystems.DriveTrain driveTrain, Intake intake, double time) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //new AutoNoShooter(storageSystem, shooter, driveTrain, intake),

      new SequentialCommandGroup(
        new AutoStorage(storageSystem, Constants.Storage.SPEED, 4),
        new ParallelCommandGroup(
          new AutoIntake(intake, 4),
          new DriveStraight(driveTrain, 0.6, 3.5)
        ),
        new DriveStraight(driveTrain, -0.7, 3),
        new AutoStorage(storageSystem, Constants.Storage.SPEED, 4)
      ),
      new AutoShoot(shooter, -Constants.Shooter.SPEED, time)
    );
  }

}
