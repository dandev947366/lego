package Team_8_Robot;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

class AvoidObject extends Thread{
	private EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S4);

	private SampleProvider sp = us.getDistanceMode();
	//private RobotRun myRun = new RobotRun();
	DataExchange de = new DataExchange();
	private int distanceRange;
	
	public  AvoidObject(DataExchange de, int distanceRange){
		
		this.de = de;
		this.distanceRange = distanceRange;

	}
	@Override
	public void run() {
		int distanceValue = 0;
		
		while(true) {
			
			float [] sample = new float[sp.sampleSize()];
		    sp.fetchSample(sample, 0);
		    distanceValue = (int)(sample[0]*100);
		    //System.out.println("Distance: "+ distanceValue);
		    //Delay.msDelay(1000);
		    if(distanceValue > distanceRange) {
		    
		    	de.setCmd(1);
		    }else {
		    	
		    	de.setCmd(0);
		   } 
		}
	}
}
