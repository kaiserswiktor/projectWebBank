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
 *Class request to comparison Email and Password. 
 */
public class DaoSelectEmailPassword implements Dao {

	public boolean selectCheckUser(String eMail, String password) throws SQLException {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String EmailPassword = resource.getString("EmailPassword");
	    ResultSet rs = null ;
		Connection cn = null;
		try {
			cn = DataSource.getInstance().getConnection();// подключение пула
															// Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = null;

			try {
				 rs = null;// 2 блок
				try { // 3 блок
					st = cn.prepareStatement(EmailPassword);
					st.setString(1, eMail);
					st.setString(2, password);
					rs = st.executeQuery();
					System.out.println(password);
					
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
		return true;
	

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