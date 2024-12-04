package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;



// what am I doing?
public class SetIndexer extends Command{
    Indexer s_Indexer;
    Indexer.indexerState state;
    
    public SetIndexer(Indexer.indexerState state) {
        s_Indexer = Indexer.getInstance();
        this.state = state;
        addRequirements(s_Indexer);
    }

    @Override
    public void initialize(){
        s_Indexer.setDirectSpeed(state);
    }

    @Override
    public void execute(){
        
    }
    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        s_Indexer.setDirectSpeed(Indexer.indexerState.OFF);
    }

    

}
