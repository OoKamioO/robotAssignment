import lejos.nxt.*;
import lejos.robotics.subsumption.*;


public class printAssignment implements Behavior
{	
	String text;
	private boolean suppressed = false;
	
	public printAssignment(String text)
	{
		this.text = text;
	}
	
	public boolean takeControl()
	{
		return true;
	}
	
	public void suppress()
	{	
		suppressed = true;
	}
	
	public void action()
	{
		suppressed = false;
		
		LCD.drawString(text, 0, 4);
		
		Button.waitForAnyPress();
		while(!suppressed)
		{
			LCD.drawString("", 0, 4);
		}
	}
}