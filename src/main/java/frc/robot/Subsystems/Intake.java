package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

import com.ctre.phoenix.motorcontrol.can.*;

public class Intake extends SubsystemBase {
    public static WPI_TalonSRX intake = new WPI_TalonSRX(Constants.INTAKE_MOTOR);

    public static void setupMotors(){

    }

    public void intakeBalls(double rpm){
        intake.set(rpm);
    }
    public void outputBalls(){
        intakeBalls((double)(Constants.OUTAKE_BALLS));
    }
    public void stopIntake(){
        intake.stopMotor();
    }
}
