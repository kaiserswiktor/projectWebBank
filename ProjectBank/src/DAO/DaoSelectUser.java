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

import tableDataBaza.CreditCard;
import tableDataBaza.Score;
import tableDataBaza.User;

/**
 * @author User
 *Class request to comparison user. 
 */
public class DaoSelectUser implements Dao {
	
	public User selectdaoUser(String login, String password)  {
			ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
			String user = resource.getString("user");
			ResultSet rs = null;
			Connection cn = null;
			User User= null;
			CreditCard creditCard;
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
						st.setString(1, login);
						st.setString(2, password);
						rs = st.executeQuery();
						 User = new User( user, user, user);
					while (rs.next()) {
						String firstName = rs.getString(2);
						String lastName = rs.getString(3);
						String role = rs.getString(6);
						int creditC=rs.getInt(7);
						
						 User = new User( firstName, lastName, role);
						 creditCard=new CreditCard(creditC);
						 System.out.println(firstName+lastName+role);
						 System.out.println(creditC);
					}
					}
					 finally { // ��� 3-�� ����� try
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
	public void insertPayment(int idScore, String typePayment, int sumPayment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}

	
}