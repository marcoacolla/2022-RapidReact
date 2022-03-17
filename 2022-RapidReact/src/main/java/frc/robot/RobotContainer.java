// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Climber;
import frc.robot.commands.DriveRobot;
import frc.robot.commands.ExtendClimber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.StorageSystem;
import frc.robot.commands.commandgroups.AutoRoutine;
import frc.robot.commands.commandgroups.IntakeAndConveyor;
import frc.robot.commands.RetractClimber;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class RobotContainer {

  //subsystems
  private final frc.robot.subsystems.DriveTrain driveTrain = new DriveTrain();
  private final Climber climber = new Climber();
  private final Shooter shooter = new Shooter();
  private final StorageSystem storageSystem = new StorageSystem();
  private final frc.robot.subsystems.Intake intake = new Intake();
  private final Controllers controllers = new Controllers();

  public RobotContainer() {
    driveTrain.setInverted(true);
    driveTrain.setDefaultCommand(new DriveRobot(driveTrain, controllers.xboxController));
    //intake.setDefaultCommand(new GrabBalls(intake, 0));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
    controllers.bButton.toggleWhenPressed(new DriveRobot(driveTrain, controllers.xboxController));
    //yButton.toggleWhenPressed(new IntakeAndConveyor(intake, storageSystem));
	  controllers.xButton.toggleWhenPressed(new Shoot(shooter, Constants.Shooter.SPEED));
    controllers.yButton.whenHeld(new IntakeAndConveyor(intake, storageSystem, 0.7));
    //controllers.rTrigger.whenHeld(new GrabBalls(intake, controllers.xboxController));
    controllers.aButton.whenHeld(new IntakeAndConveyor(intake, storageSystem, -0.7));
    controllers.lBumper.whenPressed(new ExtendClimber(climber, 1));
    controllers.rBumper.whenPressed(new RetractClimber(climber, 1, 0.4));
  }

  public ParallelCommandGroup getAutonomousCommand() {
    return new AutoRoutine(storageSystem, shooter, driveTrain, intake, 15);
  }
}
