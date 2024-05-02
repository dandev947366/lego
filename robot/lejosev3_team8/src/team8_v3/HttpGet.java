package team8_v3;
/**
 * <p>
 * This class connects to the web server to get the robot name and send statistics.
 * </p>
 *
 * @author Team 8, CA23, HAMK
 * @version 1.0
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet {
	
	/**
	 * The id of the robot.
	 */
	private static final int ID = 1;
	
	/**
	 * The address of web server.
	 */
	private static final String BASE_URL = "http://192.168.119.172:8080/rest";
	
	/**
	 * Do a HTTP GET from URL and return the contents.
	 * @param stringUrl the URL that need to be fetched.
	 * @return the return content from the URL.
	 */
	public static String get(String stringUrl) {
		String res = "";
		try {
			URL url = new URL(stringUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            System.out.println("HTTP Err: " + conn.getResponseCode() + ", " + conn.getResponseMessage());
	            return "";
	        }
			try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                res += line;
	            }
	        } finally {
	            conn.disconnect();
	        }
		}
  		catch(Exception e) {
  			e.printStackTrace();
            System.out.println("HTTP err:" + e.getMessage());
  		}
		return res;
	}
	
    /**
     * Build a URL from parts using "/" to concatenate.
     * @param parts the parts of the URL to be concatenated.
     * @return the constructed URL as a String.
     */
    public static String buildUrl(String... parts) {
    	StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(BASE_URL);
        for (String part : parts) {
            urlBuilder.append("/").append(part);
        }
        return urlBuilder.toString();
    }
    
    /**
     * Send statistic to web server.
     * @param avgSpeed the avgSpeed of a task.
     * @param startTimeMillis the start time of a task.
     * @param endTimeMillis the end time of a task.
     */
    public static void sendStatistic(int avgSpeed, long startTimeMillis, long endTimeMillis) {
    	String url = buildUrl(
    			"taskservice",
    			"addtask",
    			String.valueOf(ID), 
    			String.valueOf(avgSpeed), 
    			String.valueOf(startTimeMillis),
    			String.valueOf(endTimeMillis)
    			);
    	get(url);
    }
    
    /**
     * Update the name of robot from web server.
     * @return The name of the robot.
     */
    public static String getName() {
		String url = buildUrl("robotservice", "getrobot", String.valueOf(ID));
		return get(url);
	}

}