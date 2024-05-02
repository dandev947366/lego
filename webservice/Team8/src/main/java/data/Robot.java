/**
 * <p>
 * This class is the Model of table Robot.
 * There are two columns in the table: id and name.
 * </p>
 *
 * @author Team 8, CA23, HAMK
 * @version 1.0
 */
package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Robot")
public class Robot {
	
	/**
	 * The column id.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**
	 * The column name.
	 */
	private String name;
	

	@OneToMany(mappedBy="lego", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<LegoSetting> settings;
	
	@OneToMany(mappedBy="robot", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Task> tasks;
	
	/**
	 * The default constructor just initialize the lists to avoid the null pointer exceptions.
	 */
	public Robot() {
		settings = new ArrayList<LegoSetting>();
		tasks = new ArrayList<Task>();
	}
	
	/**
	 * The constructor initialize a new entry.
	 * @param name the name of the robot.
	 */
	public Robot(String name) {
		this();
		this.name = name;
	}
	
	/**
	 * Return the id of the entry.
	 * @return the id of the entry.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Set the id of the entry.
	 * @param id the id of the entry.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Return the name of the entry.
	 * @return the name of the entry.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the entry.
	 * @param id the name of the entry.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public List<LegoSetting> getSettings() {
		if (this.settings == null) {
			return new ArrayList<LegoSetting>();
		}
		return settings;
	}
	
	public void setSettings(List<LegoSetting> settings) {
		this.settings = settings;
	}
	
	/**
	 * Return the tasks of the robot.
	 * @return the list of tasks of the robot.
	 */
	public List<Task> getTasks() {
		if (this.tasks == null) {
			return new ArrayList<Task>();
		}
		return tasks;
	}
	
	/**
	 * Set the robot's tasks.
	 * @param tasks the tasks.
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}

/**
CREATE TABLE Robot (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB;
*/

