// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveRobot;
import frc.robot.commands.auto.DriveStraight;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.StorageSystem;
import frc.robot.commands.commandgroups.AutoSchedule;
import frc.robot.commands.commandgroups.ConveyorAndShoot;
import frc.robot.commands.ActivateConveyor;
import frc.robot.commands.auto.AutoConveyor;
import frc.robot.commands.auto.AutoIntake;
import frc.robot.commands.auto.AutoShoot;
import frc.robot.commands.GrabBalls;
import frc.robot.commands.auto.PIDDriveStraight;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;




public class RobotContainer {

  //subsystems
  private final frc.robot.subsystems.DriveTrain driveTrain = new DriveTrain();
  private final Shooter shooter = new Shooter();
  private final StorageSystem storageSystem = new StorageSystem();
  private final frc.robot.subsystems.Intake intake = new Intake();

  private final XboxController xboxController = new XboxController(Constants.Controller.CONTROLLER_ID);

   //buttons
  private final JoystickButton xButton = new JoystickButton(xboxController, XboxController.Button.kX.value);
  private final JoystickButton aButton = new JoystickButton(xboxController, XboxController.Button.kA.value);
  private final JoystickButton bButton = new JoystickButton(xboxController, XboxController.Button.kB.value);

  public RobotContainer() {
    driveTrain.setInverted(true);
    shooter.setDefaultCommand(new Shoot(shooter, Constants.Shooter.SPEED));
    driveTrain.setDefaultCommand(new DriveRobot(driveTrain, xboxController));
	  intake.setDefaultCommand(new GrabBalls(intake, xboxController));

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
    bButton.toggleWhenPressed(new DriveRobot(driveTrain, xboxController));
	  xButton.toggleWhenPressed(new Shoot(shooter, Constants.Shooter.SPEED));

	  aButton.whenHeld(new ActivateConveyor(storageSystem, Constants.Storage.SPEED));
  }

  public Command getAutonomousCommand() {
    return new ParallelCommandGroup(
      new AutoShoot(shooter, Constants.Shooter.SPEED, 15),
      new AutoSchedule(storageSystem, shooter, driveTrain, intake)
    );

  }
}
