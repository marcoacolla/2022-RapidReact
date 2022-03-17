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
    public final XboxController xboxController0 = new XboxController(0);
    public final XboxController xboxController1 = new XboxController(1);
    public final Joystick joystick = new Joystick(Constants.Controller.JOYSTICK_ID);

    // Buttons Xbox 0
    public final JoystickButton xButton0 = new JoystickButton(xboxController0, XboxController.Button.kX.value);
    public final JoystickButton aButton0 = new JoystickButton(xboxController0, XboxController.Button.kA.value);
    public final JoystickButton bButton0 = new JoystickButton(xboxController0, XboxController.Button.kB.value);
    public final JoystickButton yButton0 = new JoystickButton(xboxController0, XboxController.Button.kY.value);
    public final JoystickButton rTrigger0 = new JoystickButton(xboxController0, XboxController.Button.kStickRight.value);
    public final JoystickButton startButton0 = new JoystickButton(xboxController0, 6);
    public final JoystickButton selectButton0 = new JoystickButton(xboxController0, 7);

    //Buttons Xbox 0
    public final JoystickButton rTrigger1 = new JoystickButton(xboxController1, XboxController.Button.kStickRight.value);
    public final JoystickButton lTrigger1 = new JoystickButton(xboxController1, XboxController.Button.kStickLeft.value);
    public final JoystickButton lBumper1 = new JoystickButton(xboxController1, XboxController.Button.kBumperLeft.value);
    public final JoystickButton rBumper1 = new JoystickButton(xboxController1, XboxController.Button.kBumperRight.value);

}

