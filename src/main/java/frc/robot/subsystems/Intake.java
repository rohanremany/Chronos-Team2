package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    private static Intake instance;
    public static Intake getInstance() {
        if(instance == null) {
            instance = new Intake();
        }
        return instance;
    }

    private TalonFX m_intake;

    public Intake() {
        m_intake = new TalonFX(Constants.HardwarePorts.intake);
    }

    public enum IntakeStates {
        FORWARD(0.5),
        OFF(0),
        REV(-0.5);

        private double state;

        private double getValue() {
            return state;
        }

        IntakeStates(double state) {
            this.state = state;
        }
    }

    public void setState(IntakeStates state) {
        m_intake.set(state.state);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Speed: ", m_intake.get());
    }
}
