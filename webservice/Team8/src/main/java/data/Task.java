/**
 * <p>
 * This class is the Model of table Task.
 * There are four columns in the table: id, avgSpeed, startTimeStamp, and endTimeStamp.
 * </p>
 *
 * @author Team 8, CA23, HAMK
 * @version 1.0
 */
package data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Task")
public class Task {

	/**
	 * The id of the entry.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**
	 * The avgSpeed of an entry.
	 */
	private int avgSpeed;
	/**
	 * The start time of an entry.
	 */
	private Timestamp startTimeStamp;
	/**
	 * The end time of an entry.
	 */
	private Timestamp endTimeStamp;
	
	/**
	 * The robot of an entry.
	 */
	@ManyToOne
	@JoinColumn(name="robotid")
	@JsonBackReference
	private Robot robot;
	
	public Task() {
	}
	
	/**
	 * Constructor.
	 * @param avgSpeed The average speed of a task.
	 * @param startTimeMillis The start time of a task.
	 * @param endTimeMillis The end time of a task.
	 * @param robot The robot of the task.
	 */
	public Task(int avgSpeed, long startTimeMillis, long endTimeMillis, Robot robot) {
		this.avgSpeed = avgSpeed;
		this.startTimeStamp = new Timestamp(startTimeMillis);
		this.endTimeStamp = new Timestamp(endTimeMillis);
		this.robot = robot;
	}
	
	/**
	 * Return the id of a task.
	 * @return the task id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Set the id of a task.
	 * @param id the id of a task.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Return the average speed of a task.
	 * @return the task's average speed.
	 */
	public int getAvgSpeed() {
		return avgSpeed;
	}

	/**
	 * Set the average speed of a task.
	 * @param avgSpeed the average speed of a task.
	 */
	public void setAvgSpeed(int avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	/**
	 * Return the start time stamp of a task.
	 * @return the task's start time stamp.
	 */
	public Timestamp getStartTimeStamp() {
		return startTimeStamp;
	}

	/**
	 * Set the start time stamp of a task.
	 * @param startTimeStamp the start time stamp of a task.
	 */
	public void setStartTimeStamp(Timestamp startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
	}
	
	/**
	 * Set the start time stamp of a task.
	 * @param startTimeMillis the start time milliseconds of a task.
	 */
	public void setStartTimeStamp(long startTimeMillis) {
		this.startTimeStamp = new Timestamp(startTimeMillis);
	}

	/**
	 * Return the end time stamp of a task.
	 * @return the task's end time stamp.
	 */
	public Timestamp getEndTimeStamp() {
		return endTimeStamp;
	}

	/**
	 * Set the end time stamp of a task.
	 * @param endTimeStamp the end time stamp of a task.
	 */
	public void setEndTimeStamp(Timestamp endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
	}
	
	/**
	 * Set the end time stamp of a task.
	 * @param endTimeMillis the end time milliseconds of a task.
	 */
	public void setEndTimeStamp(long endTimeMillis) {
		this.endTimeStamp = new Timestamp(endTimeMillis);
	}
	
	/**
	 * Return the robot of a task.
	 * @return the task's robot.
	 */
	public Robot getRobot() {
		return robot;
	}
	
	/**
	 * Set the robot of a task.
	 * @param robot the task's robot.
	 */
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
}

/**
CREATE TABLE Task (
    id INT AUTO_INCREMENT PRIMARY KEY,
    avgSpeed INT DEFAULT 0,
    startTimeStamp TIMESTAMP,
    endTimeStamp TIMESTAMP,
    robotid INT,
    FOREIGN KEY (robotid) REFERENCES Robot(id)
) ENGINE=InnoDB;
*/
