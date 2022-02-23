// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.Climber;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ClimberExtend;
import frc.robot.commands.ClimberRetract;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveRobot;
import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

private final Climber climber = new Climber();

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final JoystickButton buttonRb = new JoystickButton(RobotContainer.controller, Constants.BUTTON_RB_ID);
  private final JoystickButton buttonLb = new JoystickButton(RobotContainer.controller, Constants.BUTTON_LB_ID);

  public static final XboxController controller = new XboxController(Constants.CONTROLLER_ID);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  private final DriveTrain driveTrain = new DriveTrain();
  private final JoystickButton xButton = new JoystickButton(controller, XboxController.Button.kX.value);

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveTrain.setDefaultCommand(new DriveRobot(driveTrain, controller));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    buttonRb.whenPressed(new ClimberExtend(climber, Constants.CLIMBER_SPEED));
    buttonLb.whenPressed(new ClimberRetract(climber, Constants.CLIMBER_SPEED));
    xButton.toggleWhenPressed(new DriveRobot(driveTrain, controller));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
