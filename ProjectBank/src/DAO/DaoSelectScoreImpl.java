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
import tableDataBaza.Score;

/**
 * @author User Class request to comparison Score.
 */
public class DaoSelectScoreImpl extends DaoScoreSelect {
	public Score selectDaoScore(int CreditCard) {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String user = resource.getString("score");
		ResultSet rs = null;
		Connection cn = null;
		Score score = null;
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
					st.setInt(1, CreditCard);
					rs = st.executeQuery();

					while (rs.next()) {
						int ID_SCORE = rs.getInt(3);
						int ID_Card = rs.getInt(2);
						int balance = rs.getInt(4);
						String condition = rs.getString(5);
						score = new Score(ID_SCORE, ID_Card, balance, condition);
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
		return score;

	}

}
