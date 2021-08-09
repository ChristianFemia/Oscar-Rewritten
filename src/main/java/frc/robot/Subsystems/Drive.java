package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import frc.Constants;

public class Drive extends SubsystemBase{  
   public static WPI_TalonSRX leftDriveMotor = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_ONE);
   public static WPI_TalonSRX leftDriveSlaveOne = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_TWO);
   public static WPI_TalonSRX leftDriveSlaveTwo = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_THREE);
   public static WPI_TalonSRX rightDriveMotor = new WPI_TalonSRX(Constants.RIGHT_DRIVE_MOTOR_ONE);
   public static WPI_TalonSRX rightDriveSlaveOne = new WPI_TalonSRX(Constants.RIGHT_DRIVE_MOTOR_TWO);
   public static WPI_TalonSRX rightDriveSlaveTwo = new WPI_TalonSRX(Constants.RIGHT_DRIVE_MOTOR_THREE);
   public static DifferentialDrive drive = new DifferentialDrive(leftDriveMotor, rightDriveMotor); 

    public static void setupMotors(){
        leftDriveSlaveOne.follow(leftDriveMotor);
        leftDriveSlaveTwo.follow(leftDriveMotor);
        rightDriveSlaveOne.follow(rightDriveMotor);
        rightDriveSlaveOne.follow(rightDriveMotor);

        
        leftDriveMotor.setInverted(true);
        rightDriveMotor.setInverted(false);

        leftDriveMotor.enableCurrentLimit(true);
        rightDriveMotor.enableCurrentLimit(true);

        leftDriveMotor.configContinuousCurrentLimit(3); //2.7
        rightDriveMotor.configContinuousCurrentLimit(3); //2.7

    }
    public void arcadeDrive(double speed, double turn){
        drive.arcadeDrive(speed, turn);
    }

    public static void stopMotors(){
        leftDriveMotor.stopMotor();
        leftDriveSlaveOne.stopMotor();
        leftDriveSlaveTwo.stopMotor();
        rightDriveMotor.stopMotor();
        rightDriveSlaveOne.stopMotor();
        rightDriveSlaveTwo.stopMotor();
    }


}
