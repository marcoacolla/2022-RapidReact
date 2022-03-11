// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Climber extends SubsystemBase {

  private final VictorSP leftMaster = new VictorSP(Constants.Climber.LEFT_MASTER_ID);
  private final VictorSP rightMaster = new VictorSP(Constants.Climber.RIGHT_MASTER_ID);
  private final VictorSP leftSlave = new VictorSP(Constants.Climber.LEFT_SLAVE_ID);
  private final VictorSP rightSlave = new VictorSP(Constants.Climber.RIGHT_SLAVE_ID);
  private final VictorSP upMotor = new VictorSP(Constants.Climber.UP_MOTOR_ID);

  private final SpeedControllerGroup downGroup = new SpeedControllerGroup(leftMaster, leftSlave, rightMaster, rightSlave);


  public Climber() {
  }


  public void upClimber(double speed){
    upMotor.set(speed);
  }

  public void downClimber(double speed){
    downGroup.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
