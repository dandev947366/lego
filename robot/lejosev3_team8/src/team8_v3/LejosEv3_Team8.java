package team8_v3;

import lejos.hardware.Button;

public class LejosEv3_Team8 {

	public static void main(String[] args) {
        System.out.println("Press any key to start");      
        Button.waitForAnyPress();
        DataExchange de = new DataExchange();

        try {
        	RobotDirection direction = new RobotDirection(de);
            direction.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("direction err");
		}
        try {
        	RobotSpeed speed = new RobotSpeed(de);
            speed.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("speed err");
		}
        //ultrasonicsensor run
        try {
        	AvoidObject th1 = new AvoidObject(de, 20);
            th1.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("ultrasound err");
		}
        //Colorsensor run
        
        try {
        	ColorSensor th2 = new ColorSensor(de, 10, 12);
            th2.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("Colorsensor err");
		}

        try {
        	RobotRun run = new RobotRun(de);
            run.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("run err");
		}
//        getLegoName lego = new getLegoName(de);
//        	lego.start();
	}

}