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
			cn = DataSource.getInstance().getConnection();// ����������� ����
															// Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = null;
			try { // 2 ����
				try { // 3 ����
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
				} finally { // ��� 3-�� ����� try
					/*
					 * ������� ResultSet, ���� �� ��� ������ ��� ������
					 * ��������� �� ����� ������ �� ���� ������
					 */
					if (rs != null) { // ��� �� ������ ResultSet
						rs.close();
					} else {
						System.err.println("������ �� ����� ������ �� ��");
					}
				}
			} finally

			{
				/*
				 * ������� Statement, ���� �� ��� ������ ��� ������ ��������� ��
				 * ����� �������� Statement
				 */
				if (st != null) { // ��� 2-�� ����� try
					st.close();
				} else {
					System.err.println("Statement �� ������");
				}
			}
		} catch (SQLException e) { // ��� 1-�� ����� try
			System.err.println("DB connection error: " + e);
			/*
			 * ����� ��������� � ���� SQLException
			 */
		} finally {
			/*
			 * ������� Connection, ���� �� ��� ������
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