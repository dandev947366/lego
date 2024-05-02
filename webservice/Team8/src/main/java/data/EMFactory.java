/**
 * <p>
 * This class provides the instance of Entity Manager Factory.
 * </p>
 *
 * @author Team 8, CA23, HAMK
 * @version 1.0
 */
package data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("team8");
	
	/**
	 * Return the instance Entity Manager Factory
	 * @return the instance of Entity Manager Factory
	 */
	public static EntityManagerFactory getEMFactory() {
		return emf;
	}
}
