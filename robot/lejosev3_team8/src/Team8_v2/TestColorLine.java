package Team_8_Robot;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class TestColorLine {
	private EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
	final SampleProvider sp = cs.getColorIDMode();

	
	public void ColorTest() {
		
		int colorValue = 0;
		while(true) {
			
            float [] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            colorValue = (int)(sample[0]);
 
            System.out.println("Color: " + colorValue);
            Delay.msDelay(500);
   
       }
	}

	public void run() {
		ColorTest();
	}

}
