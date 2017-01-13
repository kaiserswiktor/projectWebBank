/**
 * 
 */
package DAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author User change request Balance.
 */
public class DaoUpdateBalanceImpl extends DaoScoreUpdate {
	public void updateBalance(int balance, int idScore) {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String payment = resource.getString("balance");
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
					st = cn.prepareStatement(payment);
					st.setInt(1, balance);
					st.setInt(2, idScore);
					st.executeUpdate();
				} finally

				{
					/*
					 * ������� Statement, ���� �� ��� ������ ��� ������
					 * ��������� �� ����� �������� Statement
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
		} finally {

		}
	}

}
