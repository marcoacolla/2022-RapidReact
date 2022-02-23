// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.simulation.ADXRS450_GyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private DifferentialDrive differentialDrive;

  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.LEFT_MASTER_ID);
  private final WPI_TalonSRX leftSlave = new WPI_TalonSRX(Constants.LEFT_SLAVE_ID);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.RIGHT_MASTER_ID);
  private final WPI_TalonSRX rightSlave = new WPI_TalonSRX(Constants.RIGHT_SLAVE_ID);

  public final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  public final ADXRS450_GyroSim gyroSim = new ADXRS450_GyroSim(gyro);

  public final Encoder rightEncoder = new Encoder(
    Constants.A_CHANNEL,
    Constants.B_CHANNEL, 
    false);

  public final Encoder leftEncoder = new Encoder(
    Constants.A_CHANNEL,
    Constants.B_CHANNEL, 
    false);


  private DifferentialDrivetrainSim driveSim = DifferentialDrivetrainSim.createKitbotSim(
    KitbotMotor.kDualCIMPerSide,
    KitbotGearing.k10p71,
    KitbotWheelSize.SixInch,
    null
  );

  private Field2d field = new Field2d();
  private DifferentialDriveOdometry odometry;

  /** Creates a new DriveTrain. */
  public DriveTrain() {

    leftMaster.configFactoryDefault();
    leftSlave.configFactoryDefault();
    rightMaster.configFactoryDefault();
    rightSlave.configFactoryDefault();

    SpeedControllerGroup mLeft = new SpeedControllerGroup(leftMaster, leftSlave);
    SpeedControllerGroup mRight = new SpeedControllerGroup(rightMaster, rightSlave);

    differentialDrive = new DifferentialDrive(mLeft, mRight);

    leftEncoder.setDistancePerPulse(Constants.DISTANCE_CONVERSION);
    rightEncoder.setDistancePerPulse(Constants.DISTANCE_CONVERSION);

    //leftSlave.follow(leftMaster);
    //rightSlave.follow(rightMaster);

      SmartDashboard.putData("Field", field);
      odometry = new DifferentialDriveOdometry(driveSim.getHeading());
  }
  
    public void arcadeDrive(double moveSpeed, double rotateSpeed){
      differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
    }

    public double getAutoTurn(double destination){
      double autoErrorPercent = ((gyro.getAngle() - destination) / destination) * 100;
      return (Constants.KP_VALUE * autoErrorPercent);
    }

    public void resetEncoders(){
      rightEncoder.reset();
      leftEncoder.reset();
    }

    public double getRightTrueDistance() {
      return rightEncoder.getDistance() * Constants.DISTANCE_CONVERSION;
    }
  
    public double getLeftTrueDistance() {
      return leftEncoder.getDistance() * Constants.DISTANCE_CONVERSION;
    }
  
    public double getTrueDistance() {
      return (getLeftTrueDistance() + getRightTrueDistance()) / 2;
    }

    public Encoder getLefEncoder(){
      return leftEncoder;
    }

    public Encoder getRightEncoder(){
      return rightEncoder;
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    odometry.update(driveSim.getHeading(), driveSim.getLeftPositionMeters(), driveSim.getRightPositionMeters());
    field.setRobotPose(odometry.getPoseMeters());
  }

  @Override
  public void simulationPeriodic() {
    driveSim.setInputs(
      leftMaster.get() * RobotController.getInputVoltage(),
      -rightMaster.get() * RobotController.getInputVoltage()
    );

    driveSim.update(0.02);
    gyroSim.setAngle(-driveSim.getHeading().getDegrees());
  }
} 
