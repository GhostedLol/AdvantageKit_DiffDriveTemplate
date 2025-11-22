package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
  @AutoLog
  public static class ArmIOInputs {
    public double appliedVolts;
    public double current;
    public double position;
  }

  public default void updateInputs(ArmIOInputs inputs) {}

  public default void setVoltage(double voltage) {}

  public default void setPosition(double angle) {}

  public default void stopArm() {}
}
