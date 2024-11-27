package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase{
    public static Indexer instance;

    public static Indexer getInstance(){
        if(instance == null){
            instance = new Indexer();
        }

        return instance;
    }

    private TalonFX in_indexerMotor;
    private TalonFX out_indexerMotor;
    
    public Indexer(){
        in_indexerMotor = new TalonFX(2); //random ports
        out_indexerMotor = new TalonFX(3);

    }

    public enum indexerSpeed{
        INSPEED(0.5), //random speed
        OUTSPEED(-0.5);

        private double s;

        indexerSpeed(double s){
            this.s = s;
        }
    }

    public void setDirectSpeed(indexerSpeed speed){
        in_indexerMotor.set(speed.s);
        out_indexerMotor.set(speed.s);
    }
}
