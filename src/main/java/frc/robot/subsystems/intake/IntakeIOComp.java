package frc.robot.subsystems.intake;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.util.SparkUtil;

public class IntakeIOComp implements IntakeIO {
  private static final int ID = 1;

  private final SparkMax motor = new SparkMax(ID, SparkMax.MotorType.kBrushed);
  private final DigitalInput intakeSensor = new DigitalInput(ID);

  public IntakeIOComp() {
    SparkMaxConfig config = new SparkMaxConfig();

    config.idleMode(IdleMode.kBrake);

    SparkUtil.tryUntilOk(
        5,
        () ->
            motor.configure(
                config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters));
  }
}
