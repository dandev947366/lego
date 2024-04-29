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
	int speed;
	
	public RobotRun(DataExchange de) {
		this.de = de;
		this.speed = 50;
	}
	public void run() {
		while(true) {
			if(de.getDirection()==0) {
				if(de.getCmd()==1) {
					//follow the line
					if(de.getAct().equalsIgnoreCase("R")){	
						motorA.setPower(speed/3);
						motorD.setPower(speed);
						//Delay.msDelay(500);
					}else if(de.getAct().equalsIgnoreCase("L")){
						
						motorA.setPower(speed);
						motorD.setPower(speed/2);
						
					}
						else if(de.getAct().equalsIgnoreCase("G")){
							motorA.setPower(speed);
							motorD.setPower(speed);
						}
				}else if(de.getCmd()==0) {
					
					motorA.setPower((speed)/7);
					motorD.setPower(speed);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//avoid the obstacle
				} 
			}else if(de.getDirection()==1) {//go straight
					motorA.setPower(speed);
					motorD.setPower(speed);
				}else if(de.getDirection()==2) {//turn left
					motorA.setPower(speed);
					motorD.setPower((speed)/5);
				}else if(de.getDirection()==3) {//turn right
					motorA.setPower((speed)/5);
					motorD.setPower(speed);
				}else if(de.getDirection()==4) {//go back
					motorA.setPower(-(speed));
					motorD.setPower(-(speed));
				}else{//stop
					motorA.setPower(1);
					motorD.setPower(1);
			}	
		}
	}
}


	

