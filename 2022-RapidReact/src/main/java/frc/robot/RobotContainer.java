// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ActivateConveyor;
import frc.robot.commands.DriveRobot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.StorageSystem;
import frc.robot.commands.commandgroups.AutoRoutine;
import frc.robot.commands.commandgroups.IntakeAndConveyor;
import frc.robot.commands.GrabBalls;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class RobotContainer {

  //subsystems
  private final frc.robot.subsystems.DriveTrain driveTrain = new DriveTrain();
  private final Shooter shooter = new Shooter();
  private final StorageSystem storageSystem = new StorageSystem();
  private final frc.robot.subsystems.Intake intake = new Intake();
  private final Controllers controllers = new Controllers();

  public RobotContainer() {
    driveTrain.setInverted(true);
    driveTrain.setDefaultCommand(new DriveRobot(driveTrain, controllers.xboxController));
    intake.setDefaultCommand(new GrabBalls(intake, controllers.xboxController));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
    controllers.bButton.toggleWhenPressed(new DriveRobot(driveTrain, controllers.xboxController));
    //yButton.toggleWhenPressed(new IntakeAndConveyor(intake, storageSystem));
	  controllers.xButton.toggleWhenPressed(new Shoot(shooter, Constants.Shooter.SPEED));
    controllers.yButton.whenHeld(new IntakeAndConveyor(intake, storageSystem, controllers.xboxController));
    //controllers.rTrigger.whenHeld(new GrabBalls(intake, controllers.xboxController));
    controllers.aButton.whenHeld(new ActivateConveyor(storageSystem, -0.5));
  }

  public ParallelCommandGroup getAutonomousCommand() {
    return new AutoRoutine(storageSystem, shooter, driveTrain, intake, 15);
  }
}
