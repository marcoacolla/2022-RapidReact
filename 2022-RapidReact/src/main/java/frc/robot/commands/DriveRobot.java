// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveRobot extends CommandBase {
  //public static boolean isInverted = false;
  private final DriveTrain mDrivetrain;
  private final XboxController xboxController;
  public static boolean isInverted;
  /** Creates a new ArcadeDriver. */
  public DriveRobot(DriveTrain driveTrain, XboxController m_xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    mDrivetrain = driveTrain;
    xboxController = m_xboxController;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isInverted = !isInverted;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    double moveSpeed = xboxController.getRawAxis(1);
    double rotateSpeed = xboxController.getRawAxis(0);
    //A inversão usa o moveSpeed sem sinal negativo porque o robô já está invertido por padrão
    if(isInverted){
      mDrivetrain.arcadeDrive(moveSpeed, rotateSpeed);
    }
    else {
    mDrivetrain.arcadeDrive(-moveSpeed, rotateSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
