// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

    private final XboxController m_joystick = new XboxController(Constants.CONTROLLER_ID);

    private Shooter shooter = new Shooter();


    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        // kB = botão B do controle
        final JoystickButton kB = new JoystickButton(m_joystick, constants.BUTTON_B_ID);
        kB.whenPressed(new Shoot(shooter));
    }

    public Command getAutonomousCommand() {
        return m_autoCommand;
    }
}
