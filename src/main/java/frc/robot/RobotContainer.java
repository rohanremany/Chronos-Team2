// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.SetShooter;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }

  public final CommandXboxController driver = new CommandXboxController(0);
  private final Trigger rightTrigger = driver.rightTrigger();
  private void configureBindings() {
    rightTrigger.whileTrue(new SetShooter(Shooter.ShooterStates.ON));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
