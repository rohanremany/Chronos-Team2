// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.SetIndexer;
import frc.robot.commands.SetIntake;
import frc.robot.commands.SetShooter;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class RobotContainer {

  private static RobotContainer container;

  public static RobotContainer getInstance() {
    if(container == null) {
      container = new RobotContainer();
    }
    return container;
  }

  public RobotContainer() {
    configureBindings();
  }

  public final CommandXboxController driver = new CommandXboxController(0);
  private final Intake s_Intake = Intake.getInstance();
  private final Shooter s_Shooter = Shooter.getInstance();
  private final Indexer s_Indexer = Indexer.getInstance();

  private final Trigger driverA = driver.a();
  private final Trigger driverB = driver.b();
  private final Trigger driverX = driver.x();
  private final Trigger driverY = driver.y();
  private final Trigger driverRightBumper = driver.rightBumper();
  private final Trigger driverLeftBumper = driver.rightBumper();

  public CommandXboxController getDriverController(){
    return driver;
  }

  private void configureBindings() {

    driverA.whileTrue(new SetIndexer(Indexer.indexerState.INSPEED));
    driverB.whileTrue(new SetIndexer(Indexer.indexerState.OUTSPEED));
    driverX.whileTrue(new SetIntake(Intake.IntakeStates.FORWARD));
    driverY.whileTrue(new SetIntake(Intake.IntakeStates.REV));
    driverRightBumper.whileTrue(new SetShooter(Shooter.ShooterStates.ON));
    driverLeftBumper.whileTrue(new SetShooter(Shooter.ShooterStates.REV));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
