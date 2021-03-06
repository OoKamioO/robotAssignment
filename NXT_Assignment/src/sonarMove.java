import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class sonarMove implements Behavior
{
	private boolean suppressed = false;
	private UltrasonicSensor sonar;
	
	private int currentDistance;
	private int newDistance;
	private int distanceBeforeStop;
	
	public sonarMove(SensorPort port)
	{
		sonar = new UltrasonicSensor(port);
		
		distanceBeforeStop = 20;
	}
	
	@Override
	public boolean takeControl() 
	{
		if(sonar.getDistance() < 25)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public void action() 
	{
		suppressed = false;
		
		Motor.A.rotate(-180, true);
		Motor.C.rotate(-360, true);
		
		currentDistance = sonar.getDistance();
		newDistance = sonar.getDistance();
		
		while((currentDistance - newDistance) < distanceBeforeStop)
		{
			Motor.A.forward();
			Motor.C.forward();
		}
		
		Motor.A.rotate(-90, true);
		Motor.C.rotate(-180, true);
		
		Motor.A.forward();
		Motor.C.forward();
		
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
