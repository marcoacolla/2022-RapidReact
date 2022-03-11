// AutoNoShooterright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.auto.AutoConveyor;
import frc.robot.commands.auto.DriveStraight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.StorageSystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoNoShooter extends SequentialCommandGroup {
  /** Creates a new AutoNoShooterer. */
  public AutoNoShooter(StorageSystem storageSystem, Shooter shooter, 
  frc.robot.subsystems.DriveTrain driveTrain, frc.robot.subsystems.Intake intake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutoConveyor(storageSystem, Constants.Storage.SPEED, 4),
      new AutoIntakeDrive(intake, driveTrain, 0.6, 2),
      new DriveStraight(driveTrain,-0.6, 2),
      new AutoConveyor(storageSystem, Constants.Storage.SPEED, 4)
    );
  }
}
