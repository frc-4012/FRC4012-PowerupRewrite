package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_VictorSPX dLeftMaster = new WPI_VictorSPX(Constants.LEFT_FRONT);
  WPI_VictorSPX dLeftSlave= new WPI_VictorSPX(Constants.LEFT_BACK);
  WPI_VictorSPX dRightMaster = new WPI_VictorSPX(Constants.RIGHT_FRONT);
  WPI_VictorSPX dRightSlave = new WPI_VictorSPX(Constants.RIGHT_BACK);

  public DriveTrain(){
    super("DriveTrain");
    dFrontMaster.setInverted(true);
    dFrontSlave.follow(dFrontMaster);
    dBackSlave.follow(dBackMaster);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TankDrive());
  }
  
  /**
  *@param leftVal = joystick left Y value(-1:1)
  *@param rightVal = joystick right Y value(-1:1)
  */

  public void setRaw(double leftVal, double rightVal){
    dFrontMaster.set(ControlMode.PercentOutput, leftVal);
    dBackMaster.set(ControlMode.PercentOutput, rightVal);
  }
}
