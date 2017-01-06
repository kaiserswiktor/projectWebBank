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

import requestsDataBaza.DataSource;

/**
 * @author User
 *Class request to comparison Email and Password 
 */
public class DaoSelectEmailPassword {

	public boolean selectCheckUser(String login, String password) throws SQLException {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String EmailPassword = resource.getString("EmailPassword");
		System.out.println("yjhv");
		ResultSet rs = null;
		Connection cn = null;
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
					st = cn.prepareStatement(EmailPassword);
					st.setString(1, login);
					st.setString(2, password);
					rs = st.executeQuery();
					

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
		return rs.next();

	}
}