/**
 * 
 */
package DAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import tableDataBaza.User;

/**
 * @author User Class request to comparison user.
 */
public class DaoSelectUserImpl extends DaoSelectUser {

	public User selectDaoUser(String eMail, String password) {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String user = resource.getString("user");
		ResultSet rs = null;
		Connection cn = null;
		User User = null;

		try {
			cn = DataSource.getInstance().getConnection();// подключение пула
															// Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = null;
			try { // 2 блок
				try { // 3 блок
					st = cn.prepareStatement(user);
					st.setString(1, eMail);
					st.setString(2, password);
					rs = st.executeQuery();
					while (rs.next()) {
						int idUser = rs.getInt(1);
						String firstName = rs.getString(2);
						String lastName = rs.getString(3);
						String role = rs.getString(6);
						int idCard = rs.getInt(7);
						User = new User(idUser, firstName, lastName, eMail, password, role, idCard);
					}
				} finally { // дл€ 3-го блока try
					/*
					 * закрыть ResultSet, если он был открыт или ошибка
					 * произошла во врем€ чтени€ из него данных
					 */
					if (rs != null) { // был ли создан ResultSet
						rs.close();
					} else {
						System.err.println("ошибка во врем€ чтени€ из Ѕƒ");
					}
				}
			} finally

			{
				/*
				 * закрыть Statement, если он был открыт или ошибка произошла во
				 * врем€ создани€ Statement
				 */
				if (st != null) { // дл€ 2-го блока try
					st.close();
				} else {
					System.err.println("Statement не создан");
				}
			}
		} catch (SQLException e) { // дл€ 1-го блока try
			System.err.println("DB connection error: " + e);
			/*
			 * вывод сообщени€ о всех SQLException
			 */
		} finally {
			/*
			 * закрыть Connection, если он был открыт
			 */
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					System.err.println("Connection close error: " + e);
				}
			}
		}
		return User;

	}
}