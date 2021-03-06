import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class clapMove implements Behavior 
{
	private boolean suppressed = false;
	SoundSensor s;
	
	public clapMove(SensorPort port)
	{
		s = new SoundSensor(port);
	}
	
	@Override
	public boolean takeControl() 
	{
		if(s.readValue() > 50)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public void action() 
	{
		suppressed = false;
		
		Motor.A.forward();
		Motor.C.forward();
		
		LCD.drawString("Claps", 0, 4);
		
		while(Motor.C.isMoving() && !suppressed)
		{
			Thread.yield();
		}
		
		Motor.A.stop();
		Motor.C.stop();
	}

	@Override
	public void suppress() 
	{
		suppressed = true;
	}
}
