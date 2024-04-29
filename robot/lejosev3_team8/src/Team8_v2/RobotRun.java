package Team_8_Robot;

import java.io.File;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;
	

public class RobotRun {
	private EV3ColorSensor cs;
	private EV3UltrasonicSensor us;
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
	Stopwatch sw = new Stopwatch();

	public void goStraight() {
        motorA.setPower(30);
        motorD.setPower(30);
        //System.out.println("Robot is running");

    }
	public void goBack() {
        motorA.setPower(-30);
        motorD.setPower(-30);
        Delay.msDelay(100);
        //System.out.println("Robot is running");

    }
	public void playMusic() {
		Sound.playNote(Sound.PIANO, 1000, 5000);
        

    }
	
	public void turn(String direction, int deg) {
		
		if(direction.equalsIgnoreCase("L")) {
			switch (deg) {
			case 15:
					motorA.setPower(33 );
					motorD.setPower(10);
				break;
			case 30:
				motorA.setPower(40);
				motorD.setPower(20);
				break;
			case 45:
				motorA.setPower(40);
				motorD.setPower(10);
				break;
			case 60:
				motorA.setPower(50);
				motorD.setPower(30);
				break;
			case 75:
				motorA.setPower(50);
				motorD.setPower(10);
				break;
			case 90:
				motorA.setPower(43);
				motorD.setPower(15);
				break;
			default:
				motorA.setPower(-10);
				motorD.setPower(-10);
				break;
		}
			
		}else if(direction.equalsIgnoreCase("R")) {
			switch (deg) {
			case 15:
				motorD.setPower(35);
				motorA.setPower(15);
				break;
			case 30:
				motorD.setPower(50);
				motorA.setPower(40);
				break;
			case 45:
				motorD.setPower(50);
				motorA.setPower(30);
				break;
			case 60:
				motorD.setPower(40);
				motorA.setPower(20);
				break;
			case 75:
				motorD.setPower(40);
				motorA.setPower(10);
				break;
			case 90:
				motorD.setPower(43);
				motorA.setPower(15);
				break;
			default:
				motorA.setPower(50);
				motorD.setPower(0);
				break;
		}

		}
	}

	public void MotorStop(int r) {
		if(r<2) {
			motorA.setPower(43);
			motorD.setPower(15);
		}else {
			motorA.stop();
			motorD.stop();
			Delay.msDelay(2000);
			motorA.close(); 
			motorD.close();
			Sound.beepSequence();
			System.out.println("Robot stopped");
			System.out.println("Total time: " + sw.elapsed()/1000);
			

			
		}
		

	}
}

