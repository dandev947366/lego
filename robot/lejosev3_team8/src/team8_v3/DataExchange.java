package team8_v3;

public class DataExchange {

	private int cmd = 1;
	private String act = "G";
	private int count = 0;
	private int direction = 0;
	private int id;
	private String name;

	public DataExchange() {
		
	}
	public int getCmd() {
		synchronized(this) {
			return cmd;
		}

	}
	public void setCmd(int cmd) {
		synchronized(this) {
			this.cmd = cmd;
		}
			
	}
	public String getAct() {
		synchronized(this) {
			return act;
		}
			
	}
	public void setAct(String act) {
		synchronized(this) {
			this.act = act;
		}
	}
	public int getCount() {
		synchronized(this) {
			return count;
		}
		
	}
	public void setCount(int count) {
		synchronized(this) {
			this.count = count;
		}
		
	}

	public int getDirection() {
		synchronized(this) {
			return direction;
		}
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		synchronized(this) {
			this.id = id;
		}
		
	}
	public String getName() {
		synchronized(this) {
			return name;
		}
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDirection(int direction) {
		synchronized(this) {
			this.direction = direction;
		}
		
	}
	
	
	
}
