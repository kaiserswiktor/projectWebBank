package requestsDataBaza;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {
	private static DataSource datasource;
	private ComboPooledDataSource cpds;

	private DataSource() throws PropertyVetoException {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.DataBaza");
		String url = resource.getString("url");
		String user = resource.getString("user");
		String password = resource.getString("password");
		String driver = resource.getString("driver");
		cpds = new ComboPooledDataSource();
		cpds.setDriverClass(driver);
		cpds.setJdbcUrl(url);
		cpds.setUser(user);
		cpds.setPassword(password);
		cpds.setMinPoolSize(10);
		cpds.setAcquireIncrement(10);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(180);
	}

	public static DataSource getInstance() throws PropertyVetoException {
		if (datasource == null) {
			datasource = new DataSource();
			return datasource;
		} else {
			return datasource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}

}
