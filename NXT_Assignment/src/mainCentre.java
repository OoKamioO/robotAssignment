import lejos.nxt.*;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/*
 * Author: Trent Nguyen C13559217
 */

public class mainCentre 
{
	static printAssignment printScreen;
	
	public static void main(String[] args) 
	{
		Behavior b1 = new printAssignment("Assignment 1");
		
		Behavior[] bArray = {b1};
		
		Arbitrator arby = new Arbitrator(bArray);
		arby.start();
	}
}