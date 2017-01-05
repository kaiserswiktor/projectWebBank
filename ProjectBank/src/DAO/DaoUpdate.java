/**
 * 
 */
package DAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import requestsDataBaza.DataSource;

/**
 * @author User
 *
 */
public abstract class DaoUpdate {
	public void update() {
		Connection cn = null;
		try {
			cn = DataSource.getInstance().getConnection();// подключение пула
															// Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
	}
}
