package team8_v3;

import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class RobotRun extends Thread {
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
	EV3ColorSensor cs;
	EV3UltrasonicSensor us;
	DataExchange de;
	RobotDirection direction;
	RobotSpeed speed;
	
	public RobotRun(DataExchange de) {
		this.de = de;
	}
	public void run() {
		while(true) {
			if(de.getDirection()==0) {
				if(de.getCmd()==1) {
					//follow the line
					if(de.getAct().equalsIgnoreCase("R")){	
						motorA.setPower(de.getSpeed()/3);
						motorD.setPower(de.getSpeed());
						//Delay.msDelay(500);
					}else if(de.getAct().equalsIgnoreCase("L")){
						
						motorA.setPower(de.getSpeed());
						motorD.setPower(de.getSpeed()/2);
						
					}
						else if(de.getAct().equalsIgnoreCase("G")){
							motorA.setPower(de.getSpeed());
							motorD.setPower(de.getSpeed());
						}
				}else if(de.getCmd()==0) {
					
					motorA.setPower((de.getSpeed())/7);
					motorD.setPower(de.getSpeed());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//avoid the obstacle
				} 
			}else if(de.getDirection()==1) {//go straight
					motorA.setPower(de.getSpeed());
					motorD.setPower(de.getSpeed());
				}else if(de.getDirection()==2) {//turn left
					motorA.setPower(de.getSpeed());
					motorD.setPower((de.getSpeed())/5);
				}else if(de.getDirection()==3) {//turn right
					motorA.setPower((de.getSpeed())/5);
					motorD.setPower(de.getSpeed());
				}else if(de.getDirection()==4) {//go back
					motorA.setPower(-(de.getSpeed()));
					motorD.setPower(-(de.getSpeed()));
				}else{//stop
					motorA.setPower(1);
					motorD.setPower(1);
			}	
		}
	}
}


	

