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
					 finally { // дл€ 3-го блока try
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