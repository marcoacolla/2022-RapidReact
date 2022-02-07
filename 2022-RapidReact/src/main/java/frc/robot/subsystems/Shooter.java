// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

    private WPI_TalonSRX rightMotor = new WPI_TalonSRX(Constants.ShooterRightMotorShooterID);
    private WPI_TalonSRX leftMotor = new WPI_TalonSRX(Constants.ShooterLeftMotorShooterID);


    public Shooter() {
        rightMotor.configFactoryDefault();
        leftMotor.configFactoryDefault();

    }

    public void turnOnShooter() {
        rightMotor.set(Constants.ShooterVelocity);
        leftMotor.set(Constants.ShooterVelocity);
    }

    public void turnStandShooter() {
        rightMotor.set(-Constants.ShooterLowVelocity);
        leftMotor.set(-Constants.ShooterLowVelocity);
    }

    public void turnOffShooter() {
        rightMotor.set(0);
        leftMotor.set(0);
    }

}
