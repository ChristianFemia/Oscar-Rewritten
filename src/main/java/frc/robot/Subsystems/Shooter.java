package frc.robot.Subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.*;

import frc.Constants;

public class Shooter extends SubsystemBase {
    public static WPI_TalonSRX shooterMaster = new WPI_TalonSRX(Constants.SHOOTER_WHEEL_MOTOR_ONE);
    public static WPI_TalonSRX shooterSlave = new WPI_TalonSRX(Constants.SHOOTER_WHEEL_MOTOR_TWO);

    public static WPI_TalonSRX turret = new WPI_TalonSRX(Constants.TURRET_MOTOR);

    public static WPI_TalonSRX ballPump = new WPI_TalonSRX(Constants.BALL_PUMP_MOTOR);
    
    public static WPI_TalonSRX indexer = new WPI_TalonSRX(Constants.INDEXER_MOTOR);

    public static void setupMotors(){
        shooterSlave.follow(shooterMaster);

        shooterMaster.enableCurrentLimit(true);
        turret.enableCurrentLimit(true);
        ballPump.enableCurrentLimit(true);
        indexer.enableCurrentLimit(true);

        shooterMaster.configContinuousCurrentLimit(Constants.SHOOTER_CURRENT);
        turret.configContinuousCurrentLimit(Constants.TURRET_CURRENT);
        ballPump.configContinuousCurrentLimit(Constants.BALL_PUMP_CURRENT);
        indexer.configContinuousCurrentLimit(Constants.INDEXER_CURRENT);
        
    }
    public static void spinShooter(double RPM){
        if(RPM == 0){
            stopShooter();
        } else {
            shooterMaster.set(RPM);
        }
    }

    public static void stopShooter(){
        shooterMaster.set(0);
    }

    public static void turnTurret(double angle){
        if(turret.isRevLimitSwitchClosed() == 1 || turret.isFwdLimitSwitchClosed() == 1){
            turret.set(0);
        } else {
            turret.set(angle);
        }
    }
    public static void BallPump(double rpm){
        ballPump.set(rpm);
    }
    public static void stopBallPump(){
        ballPump.set(0);
    }

    public static void Indexer(double rpm){
        indexer.set(rpm);
    }
    public static void stopIndexer(){
        indexer.set(0);
    }

}
