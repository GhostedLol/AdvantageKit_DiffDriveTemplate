package frc.robot.subsystems.arm;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Arm extends SubsystemBase {
  private final PIDController pidController = new PIDController(0, 0, 0);
  private DutyCycleEncoder armEncoder = new DutyCycleEncoder(2147483647);

  private ArmIO io;
  private final ArmIOInputsAutoLogged inputs = new ArmIOInputsAutoLogged();

  public Arm(ArmIO parameter_io) {
    this.io = parameter_io;
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.processInputs("Arm", inputs);
  }

  public Command stop() {
    return run(() -> io.stopArm()).withName("Stop");
  }

  public Command rawControl(double volts) {
    return run(() -> io.setVoltage(volts));
  }

  public Command setAngle(double angle) {
    return run(() -> io.setPosition(angle));
  }

  // public Command getToAngle(double position) {
  //   return runEnd(() -> {
  //     Double goal = MathUtil.clamp(position, -5, 5 );
  //     Double result = MathUtil.clamp(pidController.calculate());
  //   });
  // }
}
