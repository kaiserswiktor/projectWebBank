package taskmodule3;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Connect {

	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.DataBaza");
		String url = resource.getString("url");
		String user = resource.getString("user");
		String password = resource.getString("password");
		String driver = resource.getString("driver");
	
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e1) {
		}
		return DriverManager.getConnection(url, user, password);
	}

}
