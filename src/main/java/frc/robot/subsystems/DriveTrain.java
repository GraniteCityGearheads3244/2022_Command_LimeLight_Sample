// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  private PWMVictorSPX leftMotor1;
  private PWMVictorSPX leftMotor2;
  private MotorControllerGroup leftMotorControlerGroup;
  private PWMVictorSPX rightMotro1;
  private PWMVictorSPX rightMotor2;
  private MotorControllerGroup rightMotorControlerGroup;
  private DifferentialDrive differentialDrive1;

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    leftMotor1 = new PWMVictorSPX(0);
    addChild("LeftMotor1", leftMotor1);
    leftMotor1.setInverted(false);

    leftMotor2 = new PWMVictorSPX(1);
    addChild("LeftMotor2", leftMotor2);
    leftMotor2.setInverted(false);

    leftMotorControlerGroup = new MotorControllerGroup(leftMotor1, leftMotor2);
    addChild("LeftMotorControlerGroup", leftMotorControlerGroup);

    rightMotro1 = new PWMVictorSPX(2);
    addChild("RightMotro1", rightMotro1);
    rightMotro1.setInverted(false);

    rightMotor2 = new PWMVictorSPX(3);
    addChild("RightMotor2", rightMotor2);
    rightMotor2.setInverted(false);

    rightMotorControlerGroup = new MotorControllerGroup(rightMotro1, rightMotor2);
    addChild("RightMotorControlerGroup", rightMotorControlerGroup);

    differentialDrive1 = new DifferentialDrive(leftMotorControlerGroup, rightMotorControlerGroup);
    addChild("Differential Drive 1", differentialDrive1);
    differentialDrive1.setSafetyEnabled(true);
    differentialDrive1.setExpiration(0.1);
    differentialDrive1.setMaxOutput(1.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void drivearcade(double xSpeed, double zRotation){
    differentialDrive1.arcadeDrive(xSpeed, zRotation);
  }
}
