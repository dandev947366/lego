package team8_v3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RobotSpeed extends Thread{
	

        URL url = null;
  		HttpURLConnection conn = null;
  		InputStreamReader isr = null;
  		BufferedReader br=null;
  		DataExchange de = new DataExchange();
  		String s=null;
  		int speed = 40;
  		public RobotSpeed(DataExchange de) {
  			this.de = de;
  		}
  		@Override
  		public void run() {
  			while(true) {
  				try {
  					url = new URL("http://192.168.119.172:8080/rest/lego/getspeed");
  					conn = (HttpURLConnection)url.openConnection();
  		  			//System.out.println(conn.toString()); //Tulostaa vain URLin
  					InputStream is=null;
  					try {
  						is=conn.getInputStream();
  					}
  					catch (Exception e) {
  			  			System.out.println("Exception conn.getInputSteam()");
  			  			e.printStackTrace();
  			            System.out.println("Cannot get InputStream!");
  					}
  					isr = new InputStreamReader(is);
  		      		br=new BufferedReader(isr);
  					while ((s=br.readLine())!=null){
  						//System.out.println(s);
  						speed = Integer.parseInt(s);
  						de.setSpeed(speed);
  						
  					}
  					//System.out.println(de.getSpeed());
  					
  				}
  		  		catch(Exception e) {
  		  			e.printStackTrace();
  		            System.out.println("Some problem!");
  		  		}
  			}
  		}
}
