package Team_8_Robot;

import lejos.hardware.Button;
import lejos.hardware.Sound;

public class mainProjectN {
	public static void main(String[] args) {
		DataExchange de = new DataExchange();
        System.out.println("Press any key to start");
        Button.LEDPattern(4);     // flash green led and
        Sound.beepSequenceUp(); 
       // make sound when ready.
        Button.waitForAnyPress();
        AvoidObject th2 = new AvoidObject(de,10);
        th2.start();
        ColorSensor th1 = new ColorSensor(de,15,25);       
        th1.start();
        
        
        
        
        
	
	}
}
