package frc.robot;

import com.ctre.phoenix6.configs.Slot0Configs;
//import com.ctre.phoenix6.mechanisms.swerve.LegacySwerveModule.ClosedLoopOutputType;
/*import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.swerve.SwerveModuleConstants.ClosedLoopOutputType;
import com.ctre.phoenix6.swerve.SwerveModuleConstantsFactory;
import com.ctre.phoenix6.swerve.SwerveModuleConstants.SteerFeedbackType; */

//import frc.robot.subsystems.CommandSwerveDriveTrain;
import edu.wpi.first.math.util.Units;

public class Constants {

    public static final class HardwarePorts {

        public static final int intake = 40;

        public static final int leftIndexer = 21;
        public static final int rightIndexer = 22;

        public static final int leftShooter = 31;
        public static final int rightShooter = 32;
    }
    /* 
    public static final class TunerConstants {
        private static final double kDriveGearRatio = 5.25;
        private static final double kSteerGearRatio = 21.428571428571427;
        private static final double kWheelRadiusInches = 1.9125;
        private static final double kSlipCurrentA = 300.0;
        // The steer motor uses any SwerveModule.SteerRequestType control request with the
        // output type specified by SwerveModuleConstants.SteerMotorClosedLoopOutput
        private static final Slot0Configs steerGains = new Slot0Configs()
                .withKP(40).withKI(0).withKD(0.2)
                .withKS(0).withKV(1.5).withKA(0);
        // When using closed-loop control, the drive motor uses the control
        // output type specified by SwerveModuleConstants.DriveMotorClosedLoopOutput
        private static final Slot0Configs driveGains = new Slot0Configs()
                .withKP(3).withKI(0).withKD(0)
                .withKS(0).withKV(0).withKA(0);
        // The closed-loop output type to use for the steer motors;
        // This affects the PID/FF gains for the steer motors
        private static final ClosedLoopOutputType steerClosedLoopOutput = ClosedLoopOutputType.Voltage;
        // The closed-loop output type to use for the drive motors;
        // This affects the PID/FF gains for the drive motors
        private static final ClosedLoopOutputType driveClosedLoopOutput = ClosedLoopOutputType.Voltage;
        // Theoretical free speed (m/s) at 12v applied output;
        // This needs to be tuned to your individual robot
        public static final double kSpeedAt12VoltsMps = 6.08;//shfdks

        // Every 1 rotation of the azimuth results in kCoupleRatio drive motor turns;
        // This may need to be tuned to your individual robot
        private static final double kCoupleRatio = 3.57142;
        // These are only used for simulation
        private static final double kSteerInertia = 0.00001;
        private static final double kDriveInertia = 0.001;
        // Simulated voltage necessary to overcome friction
        private static final double kSteerFrictionVoltage = 0.25;
        private static final double kDriveFrictionVoltage = 0.25;
        private static final boolean kSteerMotorReversed = true;
        private static final boolean kInvertLeftSide = false;
        private static final boolean kInvertRightSide = true;
    
        private static final String kCANbusName = "";
        private static final int kPigeonId = 2;

        public static final SwerveDrivetrainConstants DrivetrainConstants = new SwerveDrivetrainConstants()
                .withPigeon2Id(kPigeonId)
                .withCANbusName(kCANbusName);

        private static final SwerveModuleConstantsFactory ConstantCreator = new SwerveModuleConstantsFactory()
                .withDriveMotorGearRatio(kDriveGearRatio)
                .withSteerMotorGearRatio(kSteerGearRatio)
                .withWheelRadius(kWheelRadiusInches)
                .withSlipCurrent(kSlipCurrentA)
                .withSteerMotorGains(steerGains)
                .withDriveMotorGains(driveGains)
                .withSteerMotorClosedLoopOutput(steerClosedLoopOutput)
                .withDriveMotorClosedLoopOutput(driveClosedLoopOutput)
                .withSpeedAt12VoltsMps(kSpeedAt12VoltsMps)
                .withSteerInertia(kSteerInertia)
                .withDriveInertia(kDriveInertia)
                .withSteerFrictionVoltage(kSteerFrictionVoltage)
                .withDriveFrictionVoltage(kDriveFrictionVoltage)
                .withFeedbackSource(SteerFeedbackType.FusedCANcoder)
                .withCouplingGearRatio(kCoupleRatio)
                .withSteerMotorInverted(kSteerMotorReversed);

        public static final int frontLeftSteer = 1;
        public static final int frontLeftDrive = 2;
        private static final double kFrontLeftEncoderOffset = -0.24853; //-0.249267578125;
        private static final double kFrontLeftXPosInches = 8.5;
        private static final double kFrontLeftYPosInches = 10;

        public static final int backLeftSteer = 3;
        public static final int backLeftDrive = 4;
        private static final double kBackLeftEncoderOffset = 0.43725; //0.443115234375; 
        private static final double kBackLeftXPosInches = -8.5;
        private static final double kBackLeftYPosInches = 10;

        public static final int backRightSteer = 5;
        public static final int backRightDrive = 6;
        private static final double kBackRightEncoderOffset = 0.2041; //0.210693359375; 
        private static final double kBackRightXPosInches = -8.5;
        private static final double kBackRightYPosInches = -10;

        public static final int frontRightSteer = 7;
        public static final int frontRightDrive = 8;
        private static final double kFrontRightEncoderOffset = 0.413818; //0.417724609375; 
        private static final double kFrontRightXPosInches = 8.5;
        private static final double kFrontRightYPosInches = -10;

        public static final int frontLeftCancoder = 9;
        public static final int backLeftCancoder = 10;
        public static final int backRightCancoder = 11;
        public static final int frontRightCancoder = 12;

        public static final SwerveModuleConstants FrontLeft = ConstantCreator.createModuleConstants(
                frontLeftSteer, frontLeftDrive, frontLeftCancoder, kFrontLeftEncoderOffset, Units.inchesToMeters(kFrontLeftXPosInches), Units.inchesToMeters(kFrontLeftYPosInches), kInvertLeftSide, kInvertLeftSide);
        public static final SwerveModuleConstants FrontRight = ConstantCreator.createModuleConstants(
                frontRightSteer, frontRightDrive, frontRightCancoder, kFrontRightEncoderOffset, Units.inchesToMeters(kFrontRightXPosInches), Units.inchesToMeters(kFrontRightYPosInches), kInvertRightSide, kInvertRightSide);
        public static final SwerveModuleConstants BackLeft = ConstantCreator.createModuleConstants(
                backLeftSteer, backLeftDrive, backLeftCancoder, kBackLeftEncoderOffset, Units.inchesToMeters(kBackLeftXPosInches), Units.inchesToMeters(kBackLeftYPosInches), kInvertLeftSide, kInvertLeftSide);
        public static final SwerveModuleConstants BackRight = ConstantCreator.createModuleConstants(
                backRightSteer, backRightCancoder, backRightCancoder, kBackRightEncoderOffset, Units.inchesToMeters(kBackRightXPosInches), Units.inchesToMeters(kBackRightYPosInches), kInvertRightSide, kInvertRightSide);

        public static final CommandSwerveDriveTrain DriveTrain = new CommandSwerveDriveTrain(DrivetrainConstants, FrontLeft,
                FrontRight, BackLeft, BackRight);
    }*/
}
