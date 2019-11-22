package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX dFrontMaster = new WPI_TalonSRX(Constants.LEFT_FRONT);
  WPI_TalonSRX dFrontSlave = new WPI_TalonSRX(Constants.LEFT_BACK);
  WPI_TalonSRX dBackMaster = new WPI_TalonSRX(Constants.RIGHT_FRONT);
  WPI_TalonSRX dBackSlave = new WPI_TalonSRX(Constants.RIGHT_BACK);

  public DriveTrain(){
    super("DriveTrain");
    dFrontSlave.follow(dFrontMaster);
    dBackSlave.follow(dBackMaster);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TankDrive());
  }

  public void setRaw(double leftVal, double rightVal){
    dFrontMaster.set(leftVal);
    dBackMaster.set(rightVal);
  }
}
