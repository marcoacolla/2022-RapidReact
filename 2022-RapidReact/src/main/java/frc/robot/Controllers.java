// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/** Add your docs here. */
public class Controllers {
    // Controllers
    public final XboxController xboxController = new XboxController(Constants.Controller.CONTROLLER_ID);
    public final Joystick joystick = new Joystick(Constants.Controller.JOYSTICK_ID);

    // Buttons Xbox
    public final JoystickButton xButton = new JoystickButton(xboxController, XboxController.Button.kX.value);
    public final JoystickButton aButton = new JoystickButton(xboxController, XboxController.Button.kA.value);
    public final JoystickButton bButton = new JoystickButton(xboxController, XboxController.Button.kB.value);
    public final JoystickButton yButton = new JoystickButton(xboxController, XboxController.Button.kY.value);
    public final JoystickButton rTrigger = new JoystickButton(xboxController, XboxController.Button.kStickRight.value);
    public final JoystickButton lTrigger = new JoystickButton(xboxController, XboxController.Button.kStickLeft.value);
    public final JoystickButton lBumper = new JoystickButton(xboxController, XboxController.Button.kBumperLeft.value);
    public final JoystickButton rBumper = new JoystickButton(xboxController, XboxController.Button.kBumperRight.value);
    public final JoystickButton startButton = new JoystickButton(xboxController, 6);
    public final JoystickButton selectButton = new JoystickButton(xboxController, 7);
    public final POVButton povButton = new POVButton(joystick, 0);

}

