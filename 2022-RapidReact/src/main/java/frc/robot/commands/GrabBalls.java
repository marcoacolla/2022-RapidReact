// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class GrabBalls extends CommandBase {

  private final Intake intake;
  private double speed;

  public GrabBalls(Intake intake, double speed) {
    this.speed = speed;
    this.intake = intake;
    addRequirements(intake);
   
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  //   double rightTrigger = xboxController.getRawAxis(XboxController.Axis.kRightTrigger.value);
  //   double leftTrigger = xboxController.getRawAxis(XboxController.Axis.kLeftTrigger.value);
  //   if (rightTrigger > 0.3) {
  //     intake.grabBalls(rightTrigger * 0.7);
  //   } else if (leftTrigger > 0.3) {
  //     intake.grabBalls(leftTrigger * -0.7);
  //   } else {
  //     intake.grabBalls(0.0);
  //   }
  intake.grabBalls(speed);
  }


  @Override
  public void end(boolean interrupted) {
    intake.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
