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
import tableDataBaza.User;

/**
 * @author User
 *
 */
public class DaoUpdateCondition implements Dao {
	public void updateCondition(int idСard,String condition) {
			ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
			String admin = resource.getString("admin");
			Connection cn = null;
			try {
				cn = DataSource.getInstance().getConnection();// подключение пула  Connection
			} catch (SQLException | PropertyVetoException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st = null;
				try { // 2 блок
					try { // 3 блок 
					st = cn.prepareStatement(admin);
					   st.setString(1, condition);
					   st.setInt(2, idСard);
					   st.executeUpdate();
				} finally

				{
					/*
					 * закрыть Statement, если он был открыт или ошибка произошла во
					 * время создания Statement
					 */
					if (st != null) { // для 2-го блока try
						st.close();
					} else {
						System.err.println("Statement не создан");
					}
				}
			} catch (SQLException e) { // для 1-го блока try
				System.err.println("DB connection error: " + e);
				/*
				 * вывод сообщения о всех SQLException
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
		}
			finally{
			}
	}

	@Override
	public boolean selectCheckUser(String login, String password) throws SQLException {
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
	public void updateBalance(int balance, int idScore) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}


}
