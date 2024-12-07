package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Shooter.ShooterStates;


public class SetShooter extends Command{
    private final Shooter skibidiShooter;
    private Shooter.ShooterStates state;
    public SetShooter(Shooter.ShooterStates state){
        skibidiShooter = Shooter.getInstance();
        this.state = state; 
    }

    @Override
    public void initialize(){
        skibidiShooter.setSpeed(state);
    }
    
    @Override
    public void execute(){

    }

    @Override
    public boolean isFinished(){
        return skibidiShooter.getSpeed() == 0;
    }

    @Override
    public void end(boolean interrupted){
        skibidiShooter.setSpeed(ShooterStates.OFF);
    }

    //@Override public void end(boolean interrupted){ 
        //skibidiShooter.setSpeed(ShooterStates.OFF); 
    //} 
}

