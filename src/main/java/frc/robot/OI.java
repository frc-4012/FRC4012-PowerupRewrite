package frc.robot;

imprt edu.wpi.first.wpilibj.Joystick;

public class OI {
  public Joystick stickL = new Joystick(Constants.LEFT_JOY);
  public Joystick stickR = new Joystick(Constants.RIGHT_JOY);
  
  public double getLY(){
    return Joystick.getY();
  }
  
  public double getRY(){
    return Joystick.getY();
  }
}
