import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class darkSensorMovement implements Behavior
{
	LightSensor ls;
	TouchSensor ts;
	
	private boolean suppressed;
	
	public darkSensorMovement(SensorPort port1, SensorPort port2)
	{
		ls = new LightSensor(port1);
		ts = new TouchSensor(port2);
	}
	
	@Override
	public boolean takeControl() 
	{
		if(ls.getLightValue() < 20)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public void action() 
	{
		suppressed = false;
		
		Motor.A.stop();
		Motor.C.stop();
		
		Motor.A.rotate(-90, true);
		Motor.C.rotate(-180, true);
		
		Motor.A.backward();
		Motor.C.backward();
		
		while(!ts.isPressed() && !suppressed)
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
