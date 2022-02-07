// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

    private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

    private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

    private final XboxController m_joystick = new XboxController(0);

    private Shooter shooter = new Shooter();


    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        // kB = botão B do controle
        final JoystickButton kB = new JoystickButton(m_joystick, 2);
        kB.whenHeld(new CommandShooter(shooter));
        kB.whenReleased(new CommandShooter2(shooter));
    }

    public Command getAutonomousCommand() {
        return m_autoCommand;
    }
}
