/**
 * 
 */
package DAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ResourceBundle;

import tableDataBaza.Score;
import tableDataBaza.User;


/**
 * @author User
 *request to add Payment
 */
public class DaoInsertPayment implements Dao {
	public void insertPayment( int idScore, String typePayment, int sumPayment){
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String payment = resource.getString("payment");
		Connection cn = null;
		try {
			cn = DataSource.getInstance().getConnection();// ����������� ����  Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = null;
			try { // 2 ����
				try { // 3 ���� 
				st = cn.prepareStatement(payment);
				   //st.setInteger(1, idPayment);
				   st.setInt(1, idScore);
				   st.setString(2, typePayment);
				   st.setInt(3, sumPayment);
				   st.executeUpdate();
				/*  if (st != null) {
						st.close();}	*/		
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
	}
		finally{
			
		}
	}

	@Override
	public boolean selectCheckUser(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User selectDaoUser(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score selectDaoScore(int CreditCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}
}
