// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  private VictorSP intakeMotor;

  public Intake() {  
  
  intakeMotor = new VictorSP(Constants.INTAKE_MOTOR_ID);
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void grabBalls(double speed) {
  intakeMotor.set(speed);
}

  public void stopIntake() {
  intakeMotor.set(0);
}
}