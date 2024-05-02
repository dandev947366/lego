package team8_v3;

import lejos.utility.Delay;


public class Statistic extends Thread {
	
	private DataExchange de;
	private long start;
	private int sumSpeed;
	private int times;
	
	public Statistic(DataExchange de) {
		this.de = de;
	}
	
	public void run() {
		while (true) {
			if (de.getDirection() != 5 && de.getSpeed() > 0 && start == 0) {
				start = System.currentTimeMillis();
				continue;
			}
			if (de.getDirection()==5 && start > 0) {
				HttpGet.sendStatistic(sumSpeed/times, start, System.currentTimeMillis());
				start = 0;
				sumSpeed = 0;
				times = 0;
				continue;
			}
			if (start > 0) {
				times++;
				sumSpeed += de.getSpeed();
			}
			Delay.msDelay(1);
		}
	}

}
