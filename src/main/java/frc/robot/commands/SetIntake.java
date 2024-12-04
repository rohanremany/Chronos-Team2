package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class SetIntake extends Command {

    private final Intake intake;
    private Intake.IntakeStates state;

    public SetIntake(Intake.IntakeStates state) {
        intake = Intake.getInstance();
        this.state = state;
    }
    
    @Override
    public void initialize() {
        intake.setState(state);
    }
    
    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intake.setState(Intake.IntakeStates.OFF);
    }
}
