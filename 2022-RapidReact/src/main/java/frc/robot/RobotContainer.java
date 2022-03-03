// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.Climber;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ActivateConveyor;
import frc.robot.subsystems.StorageSystem;
import frc.robot.commands.ClimberCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.GrabBalls;
import frc.robot.commands.InvertMotor;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

private final Climber climber = new Climber();

public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  //subsystems
  private final StorageSystem storageSystem;
    //commands
  private final ActivateConveyor activateConveyor;
    //buttons
  private final JoystickButton kStart;
  private final JoystickButton kBack;
  
  private final XboxController xbox = new XboxController(1);
  private final Intake intake = new Intake();

  private final GrabBalls grabBalls = new GrabBalls(intake);
  private final InvertMotor invMotor = new InvertMotor(intake);
  
  private final JoystickButton buttonRb = new JoystickButton(RobotContainer.controller, Constants.BUTTON_RB_ID);
  private final JoystickButton buttonLb = new JoystickButton(RobotContainer.controller, Constants.BUTTON_LB_ID);

  public static final XboxController controller = new XboxController(Constants.CONTROLLER_ID);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  private final DriveTrain driveTrain = new DriveTrain();
  private final JoystickButton xButton = new JoystickButton(controller, XboxController.Button.kX.value);

  public RobotContainer() {
    // Configure the button bindings
    //Storage System
    storageSystem = new StorageSystem();
    //commands
    activateConveyor = new ActivateConveyor(storageSystem, 1.0);
    //buttons
    kStart =  new JoystickButton(controller, XboxController.Button.kStart.value);
    kBack = new JoystickButton(controller, XboxController.Button.kBack.value);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    kStart.whenPressed(activateConveyor);
    kBack.cancelWhenPressed(activateConveyor);
    
    final JoystickButton yButton = new JoystickButton(xbox, Constants.Y_BUTTON);
  final JoystickButton aButton = new JoystickButton(xbox, Constants.A_BUTTON);

  yButton.whenPressed(grabBalls);
  aButton.whenPressed(invMotor);
  
    buttonRb.whenPressed(new ClimberCommand(climber, Constants.CLIMBER_SPEED));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
