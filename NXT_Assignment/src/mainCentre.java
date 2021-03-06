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
		Behavior b2 = new clapMove(SensorPort.S2);
		Behavior b3 = new sonarMove(SensorPort.S1);
		Behavior b4 = new darkSensorMove(SensorPort.S3, SensorPort.S4);
		
		Behavior[] bArray = {b1, b2, b3, b4};
		
		Arbitrator arby = new Arbitrator(bArray);
		arby.start();
	}
}