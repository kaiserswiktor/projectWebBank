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
 * @author User
 *
 */
public class DaoUpdateBalance {
	public void updateBalance( int balance, int idScore){
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String payment = resource.getString("balance");
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
				st = cn.prepareStatement(payment);
				   st.setInt(1, balance);
				   st.setInt(2, idScore);
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
}
