package Team_8_Robot;

public class DataExchange {
	private int cmd = 1;

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
}
