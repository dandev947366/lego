/**
 * <p>
 * This class is the web service of a task.
 * </p>
 *
 * @author Team 8, CA23, HAMK
 * @version 1.0
 */
package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import data.EMFactory;
import data.Robot;
import data.Task;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Path("/taskservice")
public class TaskService {
	
	/**
	 * A GET method for robot to send statistic data to web server.
	 * @param id the id of a robot
	 * @param avgSpeed the average speed of a task.
	 * @param startTimeMillis the start time of a task.
	 * @param endTimeMillis the end time of a task.
	 * @return the operation result.
	 */
	@GET
	@Path("/addtask/{robotid}/{avgSpeed}/{startTimeMillis}/{endTimeMillis}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTask(
			@PathParam("robotid") int id, 
	        @PathParam("avgSpeed") int avgSpeed, 
	        @PathParam("startTimeMillis") long startTimeMillis, 
	        @PathParam("endTimeMillis") long endTimeMillis
	        ) {
		EntityManagerFactory emf = EMFactory.getEMFactory();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Robot robot = em.getReference(Robot.class, id);
		Task task = new Task(avgSpeed, startTimeMillis, endTimeMillis, robot);
		robot.getTasks().add(task);
		em.persist(task);
		em.getTransaction().commit();
		ResponseBuilder builder = Response.ok(task.getId());
		return builder.build();
	}
	
	/**
	 * A GET method to return all tasks by a robot id.
	 * @param robotid the requested robot id.
	 * @return the list of tasks.
	 */
	@GET
	@Path("/gettasks/{robotid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTasks(@PathParam("robotid") int robotid) {
		EntityManagerFactory emf = EMFactory.getEMFactory();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Robot robot = em.find(Robot.class, robotid);
		List<Task> tasks = robot.getTasks();
		em.getTransaction().commit();
		GenericEntity<List<Task>> entity = new GenericEntity<List<Task>>(tasks) {};
		ResponseBuilder builder = Response.ok(entity);
		return builder.build();
	}
}
