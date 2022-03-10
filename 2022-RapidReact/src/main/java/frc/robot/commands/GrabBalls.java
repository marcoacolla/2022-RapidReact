// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class GrabBalls extends CommandBase {

  private final Intake intake;
  private XboxController xboxController;

  public GrabBalls(Intake intake, XboxController xboxController) {
    this.intake = intake;
	  this.xboxController = xboxController;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
    intake.invert();
  }

  @Override
  public void execute() {
	double rightTrigger = xboxController.getRawAxis(XboxController.Axis.kRightTrigger.value);
	double leftTrigger = xboxController.getRawAxis(XboxController.Axis.kLeftTrigger.value);

	// if (rightTrigger > Constants.Intake.DEADBAND) {
	//   intake.grabBalls(rightTrigger * Constants.Intake.MAX_SPEED);
	// } else if (leftTrigger > Constants.Intake.DEADBAND) {
	//   intake.grabBalls(leftTrigger * Constants.Intake.MAX_SPEED);
	// } else {
	//   intake.stop();
	// }
  // }

  if(intake.isInverted()){
    intake.grabBalls(xboxController.getRawAxis(XboxController.Axis.kLeftTrigger.value)* -0.8);
  }else{
    intake.grabBalls(xboxController.getRawAxis(XboxController.Axis.kRightTrigger.value)* 0.8);}
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
