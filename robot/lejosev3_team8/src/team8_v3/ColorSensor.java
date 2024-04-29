package team8_v3;

import lejos.hardware.port.SensorPort;


import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

class ColorSensor extends Thread{
		
	private EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);

	private SampleProvider sp = cs.getRedMode();
	//private RobotRun myRun = new RobotRun();
	DataExchange de;
	private int lowValue;
	private int highValue;
	int Value = 0;
	
	public ColorSensor(DataExchange de, int lowValue, int highValue){
		
		this.de = de;
		this.lowValue = lowValue;
		this.highValue = highValue;
	}
	@Override
	public void run() {

		while(true) {
			float [] sample = new float[sp.sampleSize()];
		    sp.fetchSample(sample, 0);
		    Value = (int)(sample[0]*100);
		    //System.out.println("Color Value: "+Value);
		    
			 if(Value > highValue) {	
				 de.setAct("L");
			  //Delay.msDelay(500);
			  }else if(Value < lowValue){
				  de.setAct("R");
				   //Delay.msDelay(500);
			   } else {
				   de.setAct("G");	
				  // Delay.msDelay(500);
		    }
		}
	}
}

