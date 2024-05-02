/**
 * <p>
 * This class is the web service of a robot.
 * </p>
 *
 * @author Team 8, CA23, HAMK
 * @version 1.0
 */
package services;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Path("/robotservice")
public class RobotService {
	
	/**
	 * The POST method for adding a robot.
	 * @param robot the robot that need to be added.
	 * @return the result of operation.
	 */
	@POST
	@Path("/addrobot")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addRobot(Robot robot) {
		EntityManagerFactory emf = EMFactory.getEMFactory();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(robot);
		em.getTransaction().commit();
		ResponseBuilder builder = Response.ok(robot.getName());
		return builder.build();
	}
	
	/**
	 * The GET method of getting all robots.
	 * @return the list of robots.
	 */
	@GET
	@Path("/getrobots")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRobots() {
		EntityManagerFactory emf = EMFactory.getEMFactory();
		EntityManager em=emf.createEntityManager();
		List<Robot> robots = em.createQuery("select r from Robot r").getResultList();
		GenericEntity<List<Robot>> entity = new GenericEntity<List<Robot>>(robots) {};
		ResponseBuilder builder = Response.ok(entity);
		return builder.build();
	}
	
	/**
	 * The GET method to return a robot by it's id.
	 * @param id the robot's id.
	 * @return the robot.
	 */
	@GET
	@Path("/getrobot/{robotid}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getRobots(@PathParam("robotid") int id) {
		EntityManagerFactory emf = EMFactory.getEMFactory();
		EntityManager em= emf.createEntityManager();
		Robot robot = em.find(Robot.class, id);
		ResponseBuilder builder = Response.ok(robot.getName());
		return builder.build();
	}
	
	/**
	 * The PUT method to update a robot's name by it's id.
	 * @param id the id of robot.
	 * @param newRobot the robot.
	 * @return operation result.
	 */
	@PUT
	@Path("/updaterobot/{robotid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRobot(@PathParam("robotid") int id, Robot newRobot) {
		EntityManagerFactory emf = EMFactory.getEMFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Robot robot = em.find(Robot.class, id);
		robot.setName(newRobot.getName());
		em.merge(robot);
		em.getTransaction().commit();
		ResponseBuilder builder = Response.ok(robot.getName());
		return builder.build();
	}

}
