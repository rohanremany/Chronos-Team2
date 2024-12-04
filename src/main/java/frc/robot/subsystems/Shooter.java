package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    private static Shooter instance;
    private Follower follow = new Follower(0, false);

    public static Shooter getInstance(){
        if (instance == null){
            instance = new Shooter();
        }
        return instance;
    }

    private TalonFX m_shooterLeader;
    private TalonFX m_shooterFollower;

    public Shooter(){
        m_shooterLeader = new TalonFX(Constants.HardwarePorts.leftShooter); //random values
        m_shooterFollower = new TalonFX(Constants.HardwarePorts.rightShooter);
        
        configMotor(m_shooterLeader, false);
        configMotor(m_shooterFollower, true);

        m_shooterFollower.setControl(follow);
    }

    private void configMotor(TalonFX motor, boolean isInverted){
        TalonFXConfiguration config = new TalonFXConfiguration();
        if(isInverted == true) {
            config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        }
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        
    }

    public enum ShooterStates{
        ON(0.5),
        OFF(0),
        REV(-0.5);

        private double speed;

        private double getValue(){
            return speed;
        }

        ShooterStates(double speed) {
            this.speed = speed;
        }
    }

    public void setSpeed(ShooterStates state) {
        m_shooterLeader.set(state.speed);
        m_shooterFollower.set(state.speed);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Speed Leader: ", m_shooterLeader.get());
        SmartDashboard.putNumber("Speed Follower: ", m_shooterFollower.get());
    }
}
